package com.coca.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coca.movieapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val movie: Int? = intent?.getIntExtra(EXTRA_MOVIE_ID, DEFAULT)
        if (movie != null) { }

    }
    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie"
        const val DEFAULT = -1
    }
}