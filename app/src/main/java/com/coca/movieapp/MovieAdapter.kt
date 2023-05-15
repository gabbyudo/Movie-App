package com.coca.movieapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.coca.movieapp.databinding.ListItemBinding

class MovieAdapter(val clickListener: MovieListener)  : ListAdapter<Movie, MovieViewHolder>(NoteDiffCallback()) {

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.from(parent)
    }
}
class MovieViewHolder private constructor(val binding: ListItemBinding):
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Movie, clickListener:MovieListener) {
        binding.movieName.text = item.name

        binding.movieName.setOnClickListener {
            clickListener.onClick(item)
        }
    }
    companion object {
        fun from(parent: ViewGroup): MovieViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemBinding.inflate(layoutInflater, parent, false)
            return MovieViewHolder(binding)
        }
    }
}
class NoteDiffCallback :
    DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}
open class MovieListener(val clickListener: (recipe: Movie) -> Unit) {
    fun onClick(recipe: Movie) = clickListener(recipe)
}
