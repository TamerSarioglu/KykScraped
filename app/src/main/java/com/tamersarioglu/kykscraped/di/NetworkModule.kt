package com.tamersarioglu.kykscraped.di


import com.tamersarioglu.kykscraped.data.remote.MenuApiService
import com.tamersarioglu.kykscraped.data.remote.MenuScraperService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * Provides the HttpClient singleton instance
     */
    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    /**
     * Provides the MenuApiService implementation
     */
    @Provides
    @Singleton
    fun provideMenuApiService(client: HttpClient): MenuApiService {
        return MenuScraperService(client)
    }
}