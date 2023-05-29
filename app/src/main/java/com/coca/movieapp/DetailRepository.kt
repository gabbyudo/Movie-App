package com.coca.movieapp

class DetailRepository {
    fun getMovie(): Movie {
        val details = Movie(2, "good", "nm", "okey",
            "34",0.0, 0)
        val movie = details
        return movie

    }
}