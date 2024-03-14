package com.tao.moviemenuapi.presenter

import com.tao.moviemenuapi.model.Upcoming.OptCallBackUpcoming
import com.tao.moviemenuapi.model.Upcoming.UpcomingResponse
import com.tao.moviemenuapi.model.VolleyHandler

class UpcomingPresenter(
    private val volleyHandler: VolleyHandler,
    private val upcomingView:MVPUpcoming.UpcomingView
): MVPUpcoming.UpcomingPresenter {
    override fun fetchUpcomingMovieData(){
        upcomingView.onLoadUpcoming(true)
        volleyHandler.makeApiCallUpcoming(object : OptCallBackUpcoming {
            override fun onSuccessUpcoming(upcomingMovieResponse: UpcomingResponse) {
                upcomingView.onLoadUpcoming(false)
                upcomingView.setResultUpcoming(upcomingMovieResponse)
            }

            override fun onFailureUpcoming(message: String) {
                upcomingView.onLoadUpcoming(false)
                upcomingView.showErrorUpcoming(message)
            }
        })
    }
}