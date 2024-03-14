package com.tao.moviemenuapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tao.moviemenuapi.databinding.FragmentPopularBinding
import com.tao.moviemenuapi.model.Constant
import com.tao.moviemenuapi.model.Popular.PopularResponse
import com.tao.moviemenuapi.model.Popular.Result
import com.tao.moviemenuapi.model.VolleyHandler
import com.tao.moviemenuapi.presenter.PopularPresenter

class PopularFragment : Fragment() {

    private lateinit var binding: FragmentPopularBinding
    private lateinit var presenter: PopularPresenter
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopularBinding.inflate(inflater, container, false)
        initPresenterPopular()
        initViews()
        val recyclerView = binding.recyclerPopular
        val spanCount = 1
        recyclerView.layoutManager = GridLayoutManager(requireContext(),spanCount,LinearLayoutManager.VERTICAL,false)
        return binding.root
    }

    private fun initViews(){
        presenter.fetchPopularMovieData()
    }

    private fun initPresenterPopular(){
        presenter = PopularPresenter(VolleyHandler(this.context),this)
    }

    override fun onLoadPopular(isLoading: Boolean){
        if(isLoading){
            binding.progressPopular.visibility = View.VISIBLE
        }else{
            binding.progressPopular.visibility = View.GONE
        }
    }

    override fun setResultPopular(popularResponse: PopularResponse){
        val yourList = ArrayList<MovieDetails>()
        val list = popularResponse.results
        val count = 0
        for(i in list.indices){
            if(count<13){
                var url = "${Constant.BASE_URL_MOVIE.replace("{movie_id",list[i].poster_path.toString())}"
                yourList.add(
                    MovieDetails(
                        list[i].original_title.toString(),
                        url.toString(),
                        list[i].vote_count.toString(),
                        list[i].original_language))
            }
        }
        val adapter = MovieAdapter(requireContext(),yourList)
        binding.recyclerViewPopular.adapter = adapter
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

    override fun showErrorPopular(message: String){}
}
