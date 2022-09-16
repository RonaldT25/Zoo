package com.example.zoo.adapter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import com.example.zoo.R
import com.example.zoo.model.Animal
import com.example.zoo.utils.ShowLoading
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.coil.CoilImageState
import kotlin.coroutines.coroutineContext

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AnimalItem(animal: Animal, onClick: () -> Unit) {
  Card(modifier = Modifier
    .fillMaxWidth()
    .padding(all = 10.dp),
    backgroundColor = Color.LightGray,
    onClick = { onClick() },
    shape = RoundedCornerShape(10.dp)) {
    Row {
      CoilImage(
        imageModel = animal.image_link,
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(200.dp),
        loading = { ShowLoading() },
        failure = {
          Image(painterResource(R.drawable.ic_android_black_24dp), "content description")
        })
      Column(
        Modifier
          .padding(all = 10.dp)
      ) {
        Text(text = "Name: ${animal.name}")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Habitat: ${animal.habitat}")
      }
    }
  }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AnimalItemPreview(animal: Animal, onClick: () -> Unit) {
  Card(modifier = Modifier
    .fillMaxWidth()
    .padding(all = 10.dp),
    backgroundColor = Color.LightGray,
    onClick = { onClick() },
    shape = RoundedCornerShape(10.dp)) {
    Row {
      Image(painter = painterResource(R.drawable.ic_android_black_24dp), contentDescription = "image")
      Column(
        Modifier
          .padding(all = 10.dp)
      ) {
        Text(text = "Name: ${animal.name}")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Habitat: ${animal.habitat}")
      }
    }
  }
}



@Preview
@Composable
fun AnimalCardItem() {
  AnimalItemPreview(
    animal = Animal(
      "tes",
      "tes",
      "tes",
      "tes",
      "tes",
      1,
      "",
      "tes",
      "tes",
      "tes",
      "tes",
      "tes",
      "tes",
      "tes"
    ), {})
}

@Preview
@Composable
fun AnimalCardItem2() {
  AnimalItem(
    animal = Animal(
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
    ), {})
}

