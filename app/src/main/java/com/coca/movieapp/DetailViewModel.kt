package com.coca.movieapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel () {
    private val repository = DetailRepository()

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie>
        get() = _movie

    fun getMovie(movieId: Int) {
        viewModelScope.launch {
            _movie.value = repository.getMovie(movieId)
        }
    }
}
