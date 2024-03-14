package com.tao.moviemenuapi.presenter

import com.tao.moviemenuapi.model.NowPlaying.NowPlayingResponse
import com.tao.moviemenuapi.model.NowPlaying.OptCallBackNowPlaying
import com.tao.moviemenuapi.model.VolleyHandler

class NowPlayingPresenter(
    private val volleyHandler: VolleyHandler,
    private val nowplayingView: MVPNowplaying.NowplayingView
): MVPNowplaying.NowplayingPresenter {
    override fun fetchNowplayingMovieData() {
        nowplayingView.onLoadNowplaying(true)
        volleyHandler.makeApiCallNowPlaying(object : OptCallBackNowPlaying {
            override fun onSuccessNowplaying(nowPlayingResponse: NowPlayingResponse) {
                nowplayingView.onLoadNowplaying(false)
                nowplayingView.setResultNowplaying(nowPlayingResponse)
            }

            override fun onFailureNowplaying(message: String) {
                nowplayingView.onLoadNowplaying(false)
                nowplayingView.showErrorNowplaying(message)
            }
        })
    }
}