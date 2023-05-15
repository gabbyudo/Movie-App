package com.coca.movieapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _myMovies = MutableLiveData<List<Movie>>()
    val myMovie : LiveData<List<Movie>>
    get() = _myMovies




    fun getMovies(){
        val firstMovie = Movie( 1, "one", getResults())
        val secondMovie = Movie( 2, "two", getResults())
        val thirdMovie = Movie(3, "third", getResults())
        val fourthMovie = Movie(4, "fourth", getResults())

        val myMovies = listOf<Movie>(firstMovie,secondMovie,thirdMovie,fourthMovie)
        _myMovies.value = myMovies
    }
    fun getResults(): List<Results>{
        val results = Results(1, "fine film", "one film like dat")
        val myFilm = listOf<Results>(results)
        return myFilm
    }
}