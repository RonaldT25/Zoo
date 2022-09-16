package com.example.zoo.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zoo.adapter.AnimalItem
import com.example.zoo.di.MyApplication
import com.example.zoo.model.Animal
import com.example.zoo.viewmodel.MainViewModel
import com.example.zoo.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {
  @Inject
  lateinit var mainViewModelFactory: MainViewModelFactory

  private val viewModel: MainViewModel by viewModels {
    mainViewModelFactory
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    (application as MyApplication).appComponent.inject(this)
    viewModel.getAnimal()
    setContent {
      AnimalScreen(mainViewModel = viewModel)
    }
  }

  @Composable
  fun AnimalScreen(mainViewModel: MainViewModel) {
    val animal by mainViewModel.animalResponse.observeAsState()
    LazyColumn {
      animal?.forEach { animalItem ->
        item {
          AnimalItem(animal = animalItem, {
            val intent = Intent(this@MainActivity, DetailAnimal::class.java)
            intent.putExtra(DetailAnimal.animalBundle, animalItem)
            startActivity(intent)
          })
          Divider(thickness = 10.dp)
        }
      }
    }
  }

  @Preview
  @Composable
  fun AnimalScreenTest() {
    LazyColumn() {
      item {
        AnimalItem(animal = Animal(
          "tes",
          "tes",
          "tes",
          "tes",
          "tes",
          1,
          "https://developer.android.com/static/codelabs/jetpack-compose-animation/img/ea1442f28b3c3b39.png?hl=id",
          "tes",
          "tes",
          "tes",
          "tes",
          "tes",
          "tes",
          "tes"
        ), {
          val intent = Intent(this@MainActivity, DetailAnimal::class.java)
          startActivity(intent)
        })
        Divider(thickness = 10.dp)
        AnimalItem(
          animal = Animal(
            "tes",
            "tes",
            "tes",
            "tes",
            "tes13",
            1,
            "https://develope.android.com/static/codelabs/jetpack-compose-animation/img/ea1442f28b3c3b39.png?hl=id",
            "tes",
            "tes",
            "tes",
            "tes",
            "tes",
            "tes",
            "tes"
          ), {
            val intent = Intent(this@MainActivity, DetailAnimal::class.java)
            startActivity(intent)
          })
      }
    }
  }
}







