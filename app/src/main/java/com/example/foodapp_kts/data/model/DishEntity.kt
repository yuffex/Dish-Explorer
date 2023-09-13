package com.example.foodapp_kts.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "dishes")
data class DishEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,val name:String,
    val description:String
)
