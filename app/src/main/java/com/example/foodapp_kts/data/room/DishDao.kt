package com.example.foodapp_kts.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.foodapp_kts.data.model.DishEntity

@Dao
interface DishDao {
    @Insert
    suspend fun insert(dish: DishEntity)

    @Query("SELECT * FROM dishes")
    suspend fun getAllDishes(): List<DishEntity>
}