package com.example.foodapp_kts.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp_kts.domain.model.Dish
import com.example.foodapp_kts.domain.repostirory.DishRepository
import kotlinx.coroutines.launch

class DishViewModel(private val repository: DishRepository) : ViewModel() {
    private val _dishes = MutableLiveData<List<Dish>>()
    val dishes: LiveData<List<Dish>> get() = _dishes

    fun loadDishes(){
        viewModelScope.launch {
            val dishesList =repository.getDishes()
            _dishes.postValue(dishesList)
        }
    }
    fun saveDish(dish: Dish){
        viewModelScope.launch {
            repository.saveDish(dish)
            loadDishes()//Обновите список после сохранения
        }
    }
}