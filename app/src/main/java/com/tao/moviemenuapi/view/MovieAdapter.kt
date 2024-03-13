package com.tao.moviemenuapi.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tao.moviemenuapi.databinding.ItemMovieBinding
import com.tao.moviemenuapi.model.NowPlaying.NowPlayingMovie

class MovieAdapter(private var movies: List<NowPlayingMovie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movies.size

    fun updateMovies(newMovies: List<NowPlayingMovie>) {
        movies = newMovies
        notifyDataSetChanged()
    }

    class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: NowPlayingMovie) {
            binding.textViewMovieTitle.text = movie.title
            binding.textViewMovieOverview.text = movie.overview
        }
    }
}
