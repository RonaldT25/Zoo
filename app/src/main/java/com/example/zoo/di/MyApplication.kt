package com.example.zoo.di

import android.app.Application

class MyApplication : Application() {

  lateinit var appComponent: AppComponent

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent.builder().build()
  }
}