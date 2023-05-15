package com.coca.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coca.movieapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        const val RECIPE = "extra_recipe"
    }
}
