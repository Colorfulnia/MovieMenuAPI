package com.tao.moviemenuapi.model.TopRatedResponse

data class TopRatedResponse(
    val page: Int,
    val results: List<TopRatedMovie>,
    val total_pages: Int,
    val total_results: Int
)