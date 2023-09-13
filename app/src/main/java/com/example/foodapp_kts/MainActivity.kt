package com.example.foodapp_kts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp_kts.domain.model.Dish
import com.example.foodapp_kts.presentation.adapter.DishAdapter
import com.example.foodapp_kts.presentation.viewModel.DishViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: DishViewModelFactory
    private lateinit var viewModel: DishViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // Инициализация Dagger
        val appComponent = DaggerAppComponent.builder().build()
        appComponent.inject(this)

        // Инициализация ViewModel
        viewModel = ViewModelProvider(this, viewModelFactory).get(DishViewModel::class.java)

        // Наблюдение за изменениями в LiveData
        viewModel.dishes.observe(this, Observer { dishes ->
            // Обновите интерфейс с данными о блюдах
        })

        // Загрузка данных
        viewModel.loadDishes()
    }
    // Добавление блюда
    private fun addDish(dish: Dish) {
        viewModel.saveDish(dish)
    }
}