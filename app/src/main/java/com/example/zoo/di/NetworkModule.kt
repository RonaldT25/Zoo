package com.example.zoo.di

import com.example.zoo.api.AnimalApi
import com.example.zoo.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

  @Singleton
  @Provides
  fun providesRetrofit(): Retrofit {
    return Retrofit.Builder()
      .baseUrl(Constants.BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  @Singleton
  @Provides
  fun providesZooApi(retrofit: Retrofit) : AnimalApi {
    return retrofit.create(AnimalApi::class.java)
  }

}