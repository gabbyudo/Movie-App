package com.coca.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.coca.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.myMovie.observe(this, Observer {
            if(it != null){
                adapter = MovieAdapter(MovieListener {
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.MOVIE, it)
                    startActivity(intent)

                })
                binding.MovieRV.adapter = adapter
                adapter.submitList(it)
            }
        })
        viewModel.getMovies()

    }
}