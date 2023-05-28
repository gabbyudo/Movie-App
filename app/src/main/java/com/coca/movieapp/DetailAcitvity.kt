package com.coca.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.coca.movieapp.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    private lateinit var viewModel: DetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        val movie: Int? = intent?.getIntExtra(EXTRA_MOVIE_ID, DEFAULT)

            viewModel.movie.observe(this, Observer {
               binding.title.text= it.title
                binding.description.text = it.overview
                binding.releaseDate.text = it.release_date
                val image = binding.poster

                Picasso.with(image.context)
                    .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXWI2scXOnCZyu63frAvg2P_V7cvaHYXKKTKYg0H4kNQ&s")
                    .into(image)

            })
        viewModel.getMovies()


    }
    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie"
        const val DEFAULT = -1
    }
}