package com.coca.movieapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel: ViewModel () {
    private val _movie = MutableLiveData<Movies>()
    val movie: LiveData<Movies>
        get() = _movie

    fun getMovies() {
        val details = Movies(2, "good", "nm", "okey",
            "34",0.0, 0)
        val movie = details
        _movie.value = movie

    }
}
