package com.coca.movieapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class MovieResponse( val results: List<Movie>?)

@Parcelize
data class Movie(
    var id: Int,
    val title: String?,
    val poster_path: String?,
    val overview: String?,
    val release_date: String?,
    val vote_average: Double?,
    val vote_count: Int?



) : Parcelable

@Parcelize
data class Results(
    val id: Int,
    val description: String?,
    val name: String?
) : Parcelable

