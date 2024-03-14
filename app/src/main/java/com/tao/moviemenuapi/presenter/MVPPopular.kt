package com.tao.moviemenuapi.presenter

import com.tao.moviemenuapi.model.Popular.Result

interface MVPPopular {
    interface PopularPresenter{
        fun fetchPopularMovieData()
    }
    interface PopularView{
        fun setResultPopular(popularResponse: Result)
        fun onLoadPopular(isLoading: Boolean)
        fun showErrorPopular(message: String)
    }
}