package com.example.zoo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.zoo.repository.AnimalRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val animalRepository: AnimalRepository) :
  ViewModelProvider.Factory {
  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return MainViewModel(animalRepository) as T
  }
}