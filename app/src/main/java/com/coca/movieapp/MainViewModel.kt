package com.coca.movieapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = MovieRepository()

    private val _myMovies = MutableLiveData<List<Movie>>()
    val myMovie: LiveData<List<Movie>>
        get() = _myMovies

    fun getMovies() {
        viewModelScope.launch {
            _myMovies.value = repository.getMovies()
        }
    }

}