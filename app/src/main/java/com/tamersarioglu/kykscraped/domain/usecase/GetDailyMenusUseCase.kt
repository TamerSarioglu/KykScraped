package com.tamersarioglu.kykscraped.domain.usecase

import com.tamersarioglu.kykscraped.domain.model.DailyMenu
import com.tamersarioglu.kykscraped.domain.repository.MenuRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDailyMenusUseCase @Inject constructor(
    private val repository: MenuRepository
) {
    operator fun invoke(city: String, isBreakfast: Boolean): Flow<List<DailyMenu>> {
        return repository.getDailyMenus(city, isBreakfast)
    }
}