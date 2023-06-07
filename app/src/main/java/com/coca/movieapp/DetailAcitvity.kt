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
        val movieId: Int = intent.getIntExtra(EXTRA_MOVIE_ID, DEFAULT)
        if (movieId != DEFAULT) {

            viewModel.movie.observe(this, Observer {
                binding.title.text = it.title
                binding.description.text = it.overview
                binding.releaseDate.text = it.release_date
                val image = binding.poster

                Picasso.with(image.context)
                    .load(buildCompletePosterUrl(it.poster_path.orEmpty()))
                    .into(image)

            })
            viewModel.getMovie(movieId)
        }

    }
    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie"
        const val DEFAULT = -1
    }
    private fun buildCompletePosterUrl(filePath: String): String? {
        val baseUrl = "https://www.themoviedb.org/t/p/"
        val posterSize = "w185/"
        return "$baseUrl$posterSize$filePath"}
}