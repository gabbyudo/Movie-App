package com.coca.movieapp

class MovieRepository {


    fun getResults(): List<Results> {
        val results = Results(1, "fine film", "one film like dat")
        val myFilm = listOf<Results>(results)
        return myFilm
    }
}