package com.coca.movieapp

class MovieRepository {
     suspend fun getMovies(): List<Movie> {
         return MovieApi.retrofitService.getMovies().results.orEmpty()
     }
}