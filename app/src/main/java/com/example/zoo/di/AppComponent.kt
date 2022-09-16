package com.example.zoo.di

import com.example.zoo.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
  fun inject(mainActivity: MainActivity)
}