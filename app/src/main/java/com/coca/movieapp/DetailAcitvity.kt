package com.coca.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coca.movieapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val movie: Movie? = intent?.getParcelableExtra(MOVIE)
        if (movie != null) {
            binding.name.text = movie.title
        }
    }





    companion object {
        const val MOVIE = "extra_movie"
    }
}
