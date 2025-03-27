package com.tamersarioglu.kykscraped.di


import com.tamersarioglu.kykscraped.data.repository.MenuRepositoryImpl
import com.tamersarioglu.kykscraped.domain.repository.MenuRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    /**
     * Binds MenuRepositoryImpl to MenuRepository interface
     */
    @Binds
    @Singleton
    abstract fun bindMenuRepository(
        menuRepositoryImpl: MenuRepositoryImpl
    ): MenuRepository
}