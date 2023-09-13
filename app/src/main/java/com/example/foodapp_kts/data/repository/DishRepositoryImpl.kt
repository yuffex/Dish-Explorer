package com.example.foodapp_kts.data.repository

import com.example.foodapp_kts.data.DishService
import com.example.foodapp_kts.data.model.DishEntity
import com.example.foodapp_kts.data.room.DishDao
import com.example.foodapp_kts.domain.model.Dish
import com.example.foodapp_kts.domain.repostirory.DishRepository

class DishRepositoryImpl(private val dishService: DishService, private val dishDao: DishDao) :
    DishRepository {
    override suspend fun getDishes(): List<Dish> {
        // Используйте Retrofit для получения данных о блюдах
        val response = dishService.getDishes()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        } else
            throw Exception("Failed to fetch dishes")
    }

    override suspend fun saveDish(dish: Dish) {
        // Предположим, что DishEntity имеет конструктор, который принимает Dish
        val dishEntity = DishEntity(id = dish.id, name = dish.name, description = dish.description)
        dishDao.insert(dishEntity)
    }
}