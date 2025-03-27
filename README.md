# 🍽️ KykScraped

KykScraped is a modern Android application that displays daily menu information for KYK (Credit and Dormitories Institution) dormitories in Turkey. The app allows users to check breakfast and dinner menus for different cities.

## 📱 Features

- 🏙️ View menus for 18 different cities across Turkey
- 🍳 Toggle between breakfast and dinner menus
- 📅 Display multiple days of menu information
- 🔄 Real-time data fetching via web scraping
- 🎨 Modern Material 3 UI with Jetpack Compose
- 📊 Calorie information for each menu (when available)

## 🏗️ Architecture

The application follows Clean Architecture principles with MVVM pattern:

```
KykScraped/
├── data/           # Data layer (APIs, DTOs, Repositories implementation)
├── domain/         # Domain layer (Business logic, Models, Use cases)
└── presentation/   # UI layer (Screens, ViewModels)
```

### Key Components:

- **Clean Architecture**: Separation of concerns with three layers
- **MVVM**: Presentation layer pattern with ViewModels
- **Dependency Injection**: Using Hilt for DI
- **Kotlin Coroutines**: For async operations
- **Jetpack Compose**: For modern declarative UI
- **Repository Pattern**: For data abstraction
- **Web Scraping**: Using JSoup for HTML parsing

## 🛠️ Tech Stack

- **[Kotlin](https://kotlinlang.org/)**: Primary programming language
- **[Jetpack Compose](https://developer.android.com/jetpack/compose)**: Modern UI toolkit
- **[Material 3](https://m3.material.io/)**: Design system
- **[Hilt](https://dagger.dev/hilt/)**: Dependency injection
- **[Ktor](https://ktor.io/)**: Networking client
- **[JSoup](https://jsoup.org/)**: HTML parsing
- **[Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)**: Asynchronous programming
- **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)**: UI state management
- **[Flow](https://kotlinlang.org/docs/flow.html)**: Reactive programming

## ⚙️ Getting Started

### Prerequisites

- Android Studio Iguana | 2023.2.1 or newer
- Android SDK 35
- JDK 17 or newer

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/tamersarioglu/kykscraped.git
   ```

2. Open the project in Android Studio

3. Sync Gradle files and build the project

4. Run the application on an emulator or physical device

## 🔧 Configuration

The application uses the following configurations:

- minSdk: 24
- targetSdk: 35
- compileSdk: 35

## 🗂️ Project Structure

```
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/tamersarioglu/kykscraped/
│   │   │   │   ├── data/
│   │   │   │   │   ├── mapper/
│   │   │   │   │   ├── model/
│   │   │   │   │   ├── remote/
│   │   │   │   │   └── repository/
│   │   │   │   ├── di/
│   │   │   │   ├── domain/
│   │   │   │   │   ├── model/
│   │   │   │   │   ├── repository/
│   │   │   │   │   ├── usecase/
│   │   │   │   │   └── util/
│   │   │   │   ├── presentation/
│   │   │   │   │   ├── menu/
│   │   │   │   └── ui/theme/
│   │   │   └── res/
```

## 📲 Usage

1. Select a city from the dropdown menu
2. Toggle between breakfast and dinner menus using the switch
3. View the daily menus for the selected city and meal type

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## 👤 Author

- **Tamer Sarioğlu** - [GitHub](https://github.com/tamersarioglu)

## 🙏 Acknowledgments

- [KYK](https://kykyemek.com) for providing the menu data
- All the open-source libraries used in this project