package com.coca.movieapp


class MovieRepository {
    /* suspend fun getMovies(): List<Movie> {
         var movie = RecipeApi.retrofitService.getMovie()

         return movie


        }*/


       fun getResults(): List<Results> {
            val results = Results(1, "fine film", "one film like dat")
            val myFilm = listOf<Results>(results)
            return myFilm
        }

}