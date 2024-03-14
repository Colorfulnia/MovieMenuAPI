package com.tao.moviemenuapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.tao.moviemenuapi.databinding.FragmentUpcomingBinding
import com.tao.moviemenuapi.model.Constant
import com.tao.moviemenuapi.model.Upcoming.UpcomingResponse
import com.tao.moviemenuapi.model.VolleyHandler
import com.tao.moviemenuapi.presenter.UpcomingPresenter

class UpcomingFragment : Fragment() {
    private lateinit var binding: FragmentUpcomingBinding
    private lateinit var presenter: UpcomingPresenter
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUpcomingBinding.inflate(layoutInflater, container, false)
        initPresenterUpcoming()
        initViewsUpcoming()
        val recyclerView = binding.recyclerViewUpcoming //binding
        val spanCount = 1
        recyclerView.layoutManager = GridLayoutManager(requireContext(),spanCount,LinearLayoutManager.VERTICAL,false)
        return binding.root
    }

    private fun initViewsUpcoming(){
        presenter.fetchUpcomingMovieData()
    }

    private fun initPresenterUpcoming(){
        presenter = UpcomingPresenter(VolleyHandler(requireContext()),this)
    }

    override fun onLoadUpcoming(isLoading:Boolean){
        if(isLoading){
            binding.progressUpcoming.visibility = View.VISIBLE
        }else{
            binding.progressUpcoming.visibility = View.GONE
        }
    }

    override fun setResultUpcoming(upcomingResponse: UpcomingResponse){
        val yourList = ArrayList<MovieDetails>()
        val list = upcomingResponse.results
        for(i in list.indices){
            var url = "${Constant.BASE_URL_MOVIE.replace("{movie_id}",list[i].poster_path.toString())}"
            yourList.add(
                MovieDetails(
                    list[i].original_title.toString(),
                    url.toString(),
                    list[i].vote_count.toString())
            )
            val adapter = MovieAdapter(requireContext(),yourList)
            binding.recyclerViewUpcoming.adapter = adapter

        }
    }

    override fun showErrorUpcoming(message: String){}
}
