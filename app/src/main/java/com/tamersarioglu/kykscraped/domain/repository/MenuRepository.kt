package com.tamersarioglu.kykscraped.domain.repository

import com.tamersarioglu.kykscraped.domain.model.DailyMenu
import kotlinx.coroutines.flow.Flow

interface MenuRepository {
    fun getDailyMenus(city: String, isBreakfast: Boolean): Flow<List<DailyMenu>>
}