package com.tamersarioglu.kykscraped.data.model

data class DailyMenuDto(
    val date: String,
    val menuItems: List<String>,
    val calories: String?
)