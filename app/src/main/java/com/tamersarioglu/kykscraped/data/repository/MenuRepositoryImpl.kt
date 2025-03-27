package com.tamersarioglu.kykscraped.data.repository


import com.tamersarioglu.kykscraped.data.mapper.MenuMapper
import com.tamersarioglu.kykscraped.data.remote.MenuApiService
import com.tamersarioglu.kykscraped.domain.model.DailyMenu
import com.tamersarioglu.kykscraped.domain.repository.MenuRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Implementation of the MenuRepository interface
 */
class MenuRepositoryImpl @Inject constructor(
    private val menuApiService: MenuApiService
) : MenuRepository {

    override fun getDailyMenus(city: String, isBreakfast: Boolean): Flow<List<DailyMenu>> = flow {
        try {
            // Get menus from the API service
            val menuDtos = menuApiService.getDailyMenus(city, isBreakfast)

            // Map DTOs to domain models and emit the result
            val domainMenus = MenuMapper.mapToDomainList(menuDtos)
            emit(domainMenus)
        } catch (e: Exception) {
            // In a real app, you might want to emit an error state or handle exceptions differently
            emit(emptyList())
        }
    }.flowOn(Dispatchers.IO) // Perform on IO thread
}