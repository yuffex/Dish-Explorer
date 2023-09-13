package com.example.foodapp_kts.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp_kts.databinding.ListItemDishBinding
import com.example.foodapp_kts.domain.model.Dish

class DishAdapter(private val onItemClick: (Dish) -> Unit) :
    ListAdapter<Dish, DishAdapter.DishViewHolder>(DishDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemDishBinding.inflate(inflater, parent, false)
        return DishViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        val dish = getItem(position)
        holder.bind(dish)
    }

    inner class DishViewHolder(private val binding: ListItemDishBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val dish = getItem(position)
                    onItemClick(dish)
                }
            }
        }

        fun bind(dish: Dish) {
            binding.dishNameTextView.text = dish.name
            binding.dishDescriptionTextView.text = dish.description
        }
    }
}

class DishDiffCallback : DiffUtil.ItemCallback<Dish>() {
    override fun areItemsTheSame(oldItem: Dish, newItem: Dish): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Dish, newItem: Dish): Boolean {
        return oldItem == newItem
    }
}
