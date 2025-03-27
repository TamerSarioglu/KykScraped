package com.tamersarioglu.kykscraped.presentation.menu

import com.tamersarioglu.kykscraped.domain.model.City
import com.tamersarioglu.kykscraped.domain.model.DailyMenu
import com.tamersarioglu.kykscraped.domain.util.Result

/**
 * UI state for the Menu screen
 */
data class MenuState(
    val selectedCity: City? = null,
    val isBreakfast: Boolean = false,
    val cities: List<City> = emptyList(),
    val menuResult: Result<List<DailyMenu>> = Result.loading()
)