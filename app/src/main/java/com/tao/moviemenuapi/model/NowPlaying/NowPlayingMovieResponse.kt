package com.tao.moviemenuapi.model.NowPlaying

data class NowPlayingResponse(
    val page: Int,
    val results: List<NowPlayingMovie>,
    val total_pages: Int,
    val total_results: Int
)
