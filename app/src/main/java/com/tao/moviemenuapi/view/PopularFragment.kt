package com.tao.moviemenuapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tao.moviemenuapi.databinding.FragmentPopularBinding
import com.tao.moviemenuapi.model.PopularMovie.PopularMovie
import com.tao.moviemenuapi.presenter.PopularPresenter

class PopularFragment : Fragment() {

    private lateinit var binding: FragmentPopularBinding
    private lateinit var presenter: PopularPresenter
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularBinding.inflate(inflater, container, false)
        presenter = PopularPresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        presenter.fetchPopularMovies()
    }

    private fun setupRecyclerView() {
        adapter = MovieAdapter(emptyList())
        binding.recyclerViewPopular.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewPopular.adapter = adapter
    }

    fun onMoviesFetched(movies: List<PopularMovie>) {
        adapter.updateMovies(movies)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
