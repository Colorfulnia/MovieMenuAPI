package com.tao.moviemenuapi.presenter

import com.tao.moviemenuapi.model.Upcoming.UpcomingResponse

interface MVPUpcoming {
    interface UpcomingPresenter{
        fun fetchUpcomingMovieData()
    }
    interface UpcomingView{
        fun setResultUpcoming(upcomingMovieResponse: UpcomingResponse)
        fun onLoadUpcoming(isLoading: Boolean)
        fun showErrorUpcoming(message: String)
    }
}