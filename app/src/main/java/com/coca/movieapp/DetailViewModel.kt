package com.coca.movieapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel: ViewModel () {
    private val _movies = MutableLiveData<Movies>()
    val movies: LiveData<Movies>
        get() = movies

    fun getMovies() {
        val details = Movies(2, "good", "nm", "okey",
            "34",0.0, 0)
        val movie = details
        _movies.value = movie
    }
}
