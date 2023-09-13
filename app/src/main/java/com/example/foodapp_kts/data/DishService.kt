package com.example.foodapp_kts.data

import com.example.foodapp_kts.domain.model.Dish
import retrofit2.Response
import retrofit2.http.GET

interface DishService {
    @GET("dishes")
    suspend fun getDishes(): Response<List<Dish>>
}