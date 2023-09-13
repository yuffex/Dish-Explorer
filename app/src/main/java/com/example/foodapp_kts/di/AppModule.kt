package com.example.foodapp_kts.di

import com.example.foodapp_kts.data.DishService
import com.example.foodapp_kts.data.repository.DishRepositoryImpl
import com.example.foodapp_kts.data.room.DishDao
import com.example.foodapp_kts.domain.repostirory.DishRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideDishRepository(dishService: DishService, dishDao: DishDao): DishRepository {
        return DishRepositoryImpl(dishService, dishDao)
    }
    @Provides
    @Singleton
    fun provideDishViewModelFactory(repository: DishRepository): DishViewModelFactory {
        return DishViewModelFactory(repository)
    }
}