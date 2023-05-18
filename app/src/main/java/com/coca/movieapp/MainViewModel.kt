package com.coca.movieapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val repository = MovieRepository()

    private val _myMovies = MutableLiveData<List<Movie>>()
    val myMovie: LiveData<List<Movie>>
        get() = _myMovies

    fun getMovies() {
        val firstMovie = Movie(1, "first", repository.getResults())
        val secondMovie = Movie(2, "second", repository.getResults())
        val thirdMovie = Movie(3, "third", repository.getResults())
        val fourthMovie = Movie(4, "fourth",repository.getResults())

        val myMovies = listOf<Movie>(firstMovie, secondMovie, thirdMovie, fourthMovie)
        _myMovies.value = myMovies
    }

}