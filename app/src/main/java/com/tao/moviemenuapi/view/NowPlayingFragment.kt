package com.tao.moviemenuapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.tao.moviemenuapi.databinding.FragmentNowPlayingBinding
import com.tao.moviemenuapi.model.Constant
import com.tao.moviemenuapi.model.NowPlaying.NowPlayingMovie
import com.tao.moviemenuapi.model.NowPlaying.NowPlayingResponse
import com.tao.moviemenuapi.model.VolleyHandler
import com.tao.moviemenuapi.presenter.MVPNowplaying
import com.tao.moviemenuapi.presenter.NowPlayingPresenter

class NowPlayingFragment : Fragment() ,MVPNowplaying.NowplayingPresenter{

    private lateinit var binding: FragmentNowPlayingBinding
    private lateinit var presenter: NowPlayingPresenter
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNowPlayingBinding.inflate(layoutInflater, container, false)
        initPresenterNowPlaying()
        initViewsNowPlaying()
        val recyclerView = binding.recyclerViewNowPlaying
        val spanCount = 1
        recyclerView.layoutManager = GridLayoutManager(requireContext(),spanCount,LinearLayoutManager.VERTICAL,false)
        return binding.root
    }

    private fun initViewsNowPlaying(){
        presenter.fetchNowplayingMovieData()
    }

    private fun initPresenterNowPlaying(){
        presenter = NowPlayingPresenter(VolleyHandler(this.context), this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

//    private fun setupRecyclerView(movies: List<NowPlayingMovie>) {
//        binding.recyclerViewNowPlaying.apply {
//            layoutManager = LinearLayoutManager(requireContext())
//            adapter = MovieAdapter(movies)
//        }
//    }

    override fun setResultNowPlaying(nowPlayingPresenter: NowPlayingResponse){
        val yourList = ArrayList<MovieDetails>()
        val list = NowPlayingResponse.results
        for(i in list.indices){
            val url = "${Constant.BASE_URL_MOVIE.replace("{movie_id}",list[i].poster_path.toString())}"
            yourList.add(
                MovieDetails(
                    list[i].original_title.toString(),
                    url.toString(),
                    list[i].vote_count.toString(),
                    list[i].original_language.toString())
            )
        }
        val adapter = MovieAdapter(requireContext(),yourList)
        binding.recyclerViewNowPlaying.adapter = adapter
    }

    private fun onLoadNowPlaying(isLoading: Boolean){
        if(isLoading){
            binding.recyclerViewNowPlaying.visibility = View.VISIBLE
        }else{
            binding.recyclerViewNowPlaying.visibility = View.GONE
        }
    }

    override fun showErrorNowPlaying(message: String){

    }
}