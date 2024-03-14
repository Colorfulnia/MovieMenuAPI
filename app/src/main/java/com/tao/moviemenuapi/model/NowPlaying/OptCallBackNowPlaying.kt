package com.tao.moviemenuapi.model.NowPlaying

interface OptCallBackNowPlaying {
    fun onSuccessNowplaying(nowPlayingResponse: NowPlayingResponse)
    fun onFailureNowplaying(message:String)
}