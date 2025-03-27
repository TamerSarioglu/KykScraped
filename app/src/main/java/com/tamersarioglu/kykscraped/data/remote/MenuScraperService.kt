package com.tamersarioglu.kykscraped.data.remote

import com.tamersarioglu.kykscraped.data.model.DailyMenuDto
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import org.jsoup.Jsoup
import javax.inject.Inject
import android.util.Log

/**
 * Implementation of MenuApiService that scrapes the website
 */
class MenuScraperService @Inject constructor(
    private val client: HttpClient
) : MenuApiService {

    companion object {
        private const val TAG = "MenuScraperService"
    }

    override suspend fun getDailyMenus(city: String, mealType: Boolean): List<DailyMenuDto> {
        val url = "https://kykyemek.com/Menu/GetDailyMenu/$city?city=$city&mealType=$mealType"
        Log.d(TAG, "Fetching menu for city: $city, mealType: $mealType")

        try {
            // Fetch HTML content
            val response = client.get(url)
            val htmlContent = response.bodyAsText()
            Log.d(TAG, "Received HTML content length: ${htmlContent.length}")
            Log.d(TAG, "HTML content preview: ${htmlContent.take(500)}...")

            // Parse HTML with Jsoup
            val document = Jsoup.parse(htmlContent)
            val cards = document.select("div.card.cardStyle.mainPageColor")
            Log.d(TAG, "Found ${cards.size} menu cards")

            // Log the HTML structure for debugging
            Log.d(TAG, "Document structure: ${document.select("div").size} total divs")
            Log.d(TAG, "Card elements found: ${document.select("div.card").size}")

            val menus = cards.map { card ->
                // Extract date
                val dateElement = card.selectFirst("div.card-header p.date")
                val dateText = dateElement?.text()?.trim() ?: "Tarih bulunamadı"
                Log.d(TAG, "Found date: $dateText")

                // Extract menu items
                val menuItemElements = card.select("div.card-body > div:first-child p")
                val menuItems = menuItemElements.map { it.text().trim() }.filter { it.isNotEmpty() }
                Log.d(TAG, "Found ${menuItems.size} menu items: ${menuItems.joinToString(", ")}")

                // Extract calorie info
                val calorieElement = card.selectFirst("div.card-body p.text-end")
                val calorieText = calorieElement?.text()?.trim()
                Log.d(TAG, "Found calories: $calorieText")

                DailyMenuDto(
                    date = dateText,
                    menuItems = menuItems,
                    calories = calorieText
                )
            }

            Log.d(TAG, "Successfully parsed ${menus.size} menus")
            return menus
        } catch (e: Exception) {
            Log.e(TAG, "Error scraping menus", e)
            throw e
        }
    }
}