package com.tao.moviemenuapi.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tao.moviemenuapi.databinding.ItemMovieBinding
import com.tao.moviemenuapi.model.NowPlaying.NowPlayingMovie

class MovieAdapter(private val context: Context, private val movies: ArrayList<MovieDetails>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movies[position]
        holder.bind(currentMovie)
    }

    override fun getItemCount(): Int = movies.size
    

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieDetails) {
            binding.textViewMovieTitle.text = movie.title
            binding.rating.text = movie.rating
            Picasso.get().load(movie.image).into(binding.imageView2)
            binding.language.text = movie.language
        }
    }
}
