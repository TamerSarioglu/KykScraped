package com.tamersarioglu.kykscraped.data.remote

import com.tamersarioglu.kykscraped.data.model.DailyMenuDto

/**
 * Interface defining the menu API service
 */
interface MenuApiService {
    /**
     * Get daily menus for the specified city
     * @param city The city to get menus for
     * @param mealType The meal type filter
     * @return Flow of DailyMenuDto list
     */
    suspend fun getDailyMenus(city: String, mealType: Boolean): List<DailyMenuDto>
}