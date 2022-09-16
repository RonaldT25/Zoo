package com.example.zoo.repository

import com.example.zoo.api.AnimalApi
import com.example.zoo.model.Animal
import javax.inject.Inject

class AnimalRepository @Inject constructor(private val animalApi: AnimalApi) {
  suspend fun getAnimals() : List<Animal> {
    return animalApi.getAnimal()
  }
}