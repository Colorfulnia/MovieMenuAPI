package com.tao.moviemenuapi.presenter

import com.tao.moviemenuapi.model.PopularMovie.PopularMovie

interface MVPPopular {
    interface PopularPresenter{
        fun fetchPopularMovieData()
    }
    interface PopularView{
        fun setResultPopular(popularResponse: PopularMovie)
        fun onLoadPopular(isLoading: Boolean)
        fun showErrorPopular(message: String)
    }
}