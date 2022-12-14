package com.example.zoo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Animal (
    val active_time: String,
    val animal_type: String,
    val diet: String,
    val geo_range: String,
    val habitat: String,
    val id: Int,
    val image_link: String,
    val latin_name: String,
    val length_max: String,
    val length_min: String,
    val lifespan: String,
    val name: String,
    val weight_max: String,
    val weight_min: String
) : Parcelable
