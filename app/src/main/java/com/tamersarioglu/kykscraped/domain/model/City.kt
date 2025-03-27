package com.tamersarioglu.kykscraped.domain.model

data class City(
    val name: String,
    val code: String
)

object Cities {
    val list = listOf(
        City("Adana", "Adana"),
        City("Ankara", "Ankara"),
        City("Antalya", "Antalya"),
        City("Bolu", "Bolu"),
        City("Çanakkale", "Canakkale"),
        City("Eskişehir", "Eskisehir"),
        City("Gaziantep", "Gaziantep"),
        City("Isparta", "Isparta"),
        City("İstanbul", "Istanbul"),
        City("İzmir", "Izmir"),
        City("Kahramanmaraş", "Kahramanmaras"),
        City("Karabük", "Karabuk"),
        City("Karaman", "Karaman"),
        City("Konya", "Konya"),
        City("Sakarya", "Sakarya"),
        City("Samsun", "Samsun"),
        City("Sivas", "Sivas"),
        City("Trabzon", "Trabzon"),
    )
} 