package com.tamersarioglu.kykscraped.presentation.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tamersarioglu.kykscraped.domain.util.Result
import com.tamersarioglu.kykscraped.presentation.menu.components.*
import com.tamersarioglu.kykscraped.ui.theme.KykScrapedTheme

@Composable
fun MenuScreen(
    viewModel: MenuViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()

    KykScrapedTheme {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                MenuHeader()

                // City and Meal Type Selection Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        CitySelectionCard(
                            cities = state.cities,
                            selectedCity = state.selectedCity,
                            onCitySelected = viewModel::selectCity
                        )

                        MealTypeToggle(
                            isBreakfast = state.isBreakfast,
                            onToggle = viewModel::toggleMealType
                        )
                    }
                }

                MenuList(menuResult = state.menuResult)
            }

            // Loading Overlay
            if (state.menuResult is Result.Loading) {
                LoadingOverlay()
            }
        }
    }
}