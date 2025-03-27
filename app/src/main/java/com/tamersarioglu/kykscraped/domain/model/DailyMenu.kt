package com.tamersarioglu.kykscraped.domain.model


data class DailyMenu(
    val date: String,
    val menuItems: List<String>,
    val calories: String?
)