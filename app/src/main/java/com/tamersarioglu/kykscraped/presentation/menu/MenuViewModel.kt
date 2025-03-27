package com.tamersarioglu.kykscraped.presentation.menu

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamersarioglu.kykscraped.domain.model.City
import com.tamersarioglu.kykscraped.domain.model.Cities
import com.tamersarioglu.kykscraped.domain.usecase.GetDailyMenusUseCase
import com.tamersarioglu.kykscraped.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val getDailyMenusUseCase: GetDailyMenusUseCase
) : ViewModel() {

    companion object {
        private const val TAG = "MenuViewModel"
    }

    // Mutable state flow to update the UI state
    private val _state = MutableStateFlow(MenuState(cities = Cities.list))

    // Immutable state flow exposed to the UI
    val state: StateFlow<MenuState> = _state.asStateFlow()

    init {
        Log.d(TAG, "MenuViewModel init started")
        // Set default city to Istanbul
        selectCity(Cities.list.find { it.name == "İstanbul" } ?: Cities.list.first())
    }

    fun selectCity(city: City) {
        _state.value = _state.value.copy(selectedCity = city)
        loadMenus()
    }

    fun toggleMealType() {
        _state.value = _state.value.copy(isBreakfast = !_state.value.isBreakfast)
        loadMenus()
    }

    /**
     * Loads the daily menus using the use case
     */
    private fun loadMenus() {
        val selectedCity = _state.value.selectedCity ?: return
        Log.d(TAG, "Starting to load menus for ${selectedCity.name}, isBreakfast: ${_state.value.isBreakfast}")
        
        getDailyMenusUseCase(selectedCity.code, _state.value.isBreakfast)
            .onStart {
                Log.d(TAG, "Menu loading started")
                _state.value = _state.value.copy(menuResult = Result.loading())
            }
            .onEach { menus ->
                Log.d(TAG, "Received ${menus.size} menus")
                _state.value = _state.value.copy(menuResult = Result.success(menus))
            }
            .catch { e ->
                Log.e(TAG, "Error loading menus", e)
                _state.value = _state.value.copy(
                    menuResult = Result.error(
                        message = e.localizedMessage ?: "An unexpected error occurred",
                        exception = if (e is Exception) e else Exception(e)
                    )
                )
            }
            .launchIn(viewModelScope)
    }
}