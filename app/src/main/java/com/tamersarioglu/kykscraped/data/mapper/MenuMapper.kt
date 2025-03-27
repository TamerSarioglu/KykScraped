package com.tamersarioglu.kykscraped.data.mapper

import com.tamersarioglu.kykscraped.data.model.DailyMenuDto
import com.tamersarioglu.kykscraped.domain.model.DailyMenu


/**
 * Mapper to convert between data (DTO) and domain models
 */
object MenuMapper {
    /**
     * Maps a data layer DTO to a domain model
     */
    fun mapToDomain(dto: DailyMenuDto): DailyMenu {
        return DailyMenu(
            date = dto.date,
            menuItems = dto.menuItems,
            calories = dto.calories
        )
    }

    /**
     * Maps a list of DTOs to a list of domain models
     */
    fun mapToDomainList(dtos: List<DailyMenuDto>): List<DailyMenu> {
        return dtos.map { mapToDomain(it) }
    }
}