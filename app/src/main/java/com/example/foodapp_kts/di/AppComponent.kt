package com.example.foodapp_kts.di

import com.example.foodapp_kts.App
import com.example.foodapp_kts.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}