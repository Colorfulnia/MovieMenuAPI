package com.tao.moviemenuapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.tao.moviemenuapi.databinding.FragmentNowPlayingBinding
import com.tao.moviemenuapi.model.NowPlaying.Movies
import com.tao.moviemenuapi.model.NowPlaying.NowPlayingMovie
import com.tao.moviemenuapi.model.NowPlaying.NowPlayingMovieResponse

class NowPlayingFragment : Fragment() {

    private var _binding: FragmentNowPlayingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNowPlayingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = "https://api.themoviedb.org/3/movie/now_playing?api_key=YOUR_API_KEY"

        val request = StringRequest(Request.Method.GET, url,
            { response ->
                val gson = Gson()
                val movieResponse = gson.fromJson(response, NowPlayingMovieResponse::class.java)
                val movies = movieResponse.results
                setupRecyclerView(movies)
            },
            { error ->
                //  error
                error.printStackTrace()
            })

        Volley.newRequestQueue(requireContext()).add(request)
    }

    private fun setupRecyclerView(movies: List<NowPlayingMovie>) {
        binding.recyclerViewNowPlaying.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = MovieAdapter(movies)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}