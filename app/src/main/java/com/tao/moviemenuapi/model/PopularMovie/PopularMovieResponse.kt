package com.tao.moviemenuapi.model.PopularMovie

data class PopularMovieResponse(
    val page: Int,
    val results: List<PopularMovie>,
    val total_pages: Int,
    val total_results: Int
)