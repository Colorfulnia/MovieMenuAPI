package com.tao.moviemenuapi.presenter

import com.tao.moviemenuapi.model.NowPlaying.NowPlayingResponse

interface MVPNowplaying {
    interface NowplayingPresenter{
        fun fetchNowplayingMovieData()
    }
    interface NowplayingView{
        fun setResultNowplaying(nowPlayingResponse: NowPlayingResponse)
        fun onLoadNowplaying(isLoading: Boolean)
        fun showErrorNowplaying(message: String)
    }
}