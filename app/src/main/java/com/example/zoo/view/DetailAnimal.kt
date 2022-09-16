package com.example.zoo.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zoo.R
import com.example.zoo.model.Animal
import com.example.zoo.utils.ShowLoading
import com.skydoves.landscapist.coil.CoilImage

class DetailAnimal : ComponentActivity() {

  companion object {
    const val animalBundle = "ANIMAL_BUNDLE"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      intent.getParcelableExtra<Animal>(animalBundle)?.let { DetailScreen(it) }
    }
  }

  @Composable
  fun DetailScreen(animal: Animal) {
    Scaffold(topBar = { TopBar(animal.name) }) {
      Surface(
        modifier = Modifier
          .fillMaxSize(),
        color = Color.LightGray
      ) {
        LazyColumn() {
          item {
            CoilImage(
              imageModel = animal.image_link,
              contentScale = ContentScale.FillWidth,
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
                Text(text = buildAnnotatedString {
                  append("Latin Name: ")
                  pushStyle(SpanStyle(fontStyle = FontStyle.Italic))
                  append(animal.latin_name)
                  //pop()

                })
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Type: ${animal.animal_type}")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Habitat: ${animal.habitat}")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Lifespan: ${animal.lifespan} Year")
              }
          }
        }
      }
    }
  }

  @Composable
  fun TopBar(text: String) {
    TopAppBar(backgroundColor = Color.Blue) {
      Row(
        modifier = Modifier.padding(start = 8.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Image(painterResource(id = R.drawable.ic_baseline_arrow_back_24), "", modifier = Modifier
          .size(55.dp)
          .clickable(indication = null,
            interactionSource = remember { MutableInteractionSource() }) { onBackPressed() })
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Yellow)
      }
    }
  }

  @Preview
  @Composable
  fun DetailScreenPreview() {
    DetailScreen(
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
      )
    )
  }
}







