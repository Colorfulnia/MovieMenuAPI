package com.tao.moviemenuapi.presenter

interface MVPNowplaying {
    interface NowplayingPresenter{
        fun fetchNowplayingMovieData()
    }
    interface NowplayingView{
        fun setResultNowplaying(nowPlayingResponse: NowplayingMovieResponse)
        fun onLoadNowplaying(isLoading: Boolean)
        fun showErrorNowplaying(message: String)

    }