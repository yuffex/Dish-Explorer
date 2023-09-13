package com.example.foodapp_kts.domain.repostirory

import com.example.foodapp_kts.domain.model.Dish

interface DishRepository {
    suspend fun getDishes(): List<Dish>
    suspend fun saveDish(dish: Dish)
}