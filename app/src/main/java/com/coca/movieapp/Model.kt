package com.coca.movieapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    val id : Int,
    val name : String,
    val results : List<Results>
    ): Parcelable

@Parcelize
data class Results (
    val id: Int,
    val description : String,
    val name : String
): Parcelable

