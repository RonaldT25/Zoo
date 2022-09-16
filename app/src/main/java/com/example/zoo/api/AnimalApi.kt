package com.example.zoo.api

import com.example.zoo.model.Animal
import retrofit2.http.GET

interface AnimalApi {
    @GET("animals/rand/10")
    suspend fun getAnimal() : List<Animal>
}