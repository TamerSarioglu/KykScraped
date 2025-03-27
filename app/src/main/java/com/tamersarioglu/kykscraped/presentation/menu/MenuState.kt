package com.tamersarioglu.kykscraped.presentation.menu

import com.tamersarioglu.kykscraped.domain.model.City
import com.tamersarioglu.kykscraped.domain.model.DailyMenu


/**
 * UI state for the Menu screen
 */
data class MenuState(
    val isLoading: Boolean = false,
    val menus: List<DailyMenu> = emptyList(),
    val error: String? = null,
    val selectedCity: City? = null,
    val isBreakfast: Boolean = true,
    val cities: List<City> = emptyList()
)