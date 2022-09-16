package com.example.zoo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zoo.model.Animal
import com.example.zoo.repository.AnimalRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val animalRepository: AnimalRepository) : ViewModel() {
  private val _animalResponse: MutableLiveData<List<Animal>> = MutableLiveData()
  val animalResponse : LiveData<List<Animal>> = _animalResponse

  init {
    getAnimal()
  }

  fun getAnimal() {
    viewModelScope.launch {
      _animalResponse.value = animalRepository.getAnimals()
    }
  }
}