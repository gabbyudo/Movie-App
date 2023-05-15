package com.coca.movieapp

import android.media.Image

data class Movie (
    val id : Int,
    val name : String,
    val results : List<Results>,
    val image : Int

)
data class Results (
    val id: Int,
    val description : String,
    val name : String
)