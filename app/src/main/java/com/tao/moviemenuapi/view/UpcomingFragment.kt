package com.tao.moviemenuapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.tao.moviemenuapi.databinding.FragmentTopRatedBinding
import com.tao.moviemenuapi.model.TopRatedResponse.TopRatedResponse

class UpcomingFragment : Fragment() {

    private var _binding: FragmentTopRatedBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: TopRatedPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTopRatedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        fetchTopRatedMovies()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewTopRated.layoutManager = LinearLayoutManager(context)

    }

    private fun fetchTopRatedMovies() {
        val url = "Your API URL here"
        val queue = Volley.newRequestQueue(context)
        val gson = Gson()

        val request = StringRequest(Request.Method.GET, url, { response ->
            val topRatedResponse = gson.fromJson(response, TopRatedResponse::class.java)
            val movies = topRatedResponse.results
            binding.recyclerViewTopRated.adapter = MovieAdapter(movies)
        }, { error ->
            // Handle error
        })

        queue.add(request)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
