package com.tao.moviemenuapi.model.Upcoming

import com.tao.moviemenuapi.model.Popular.PopularResponse

interface OptCallBackUpcoming {
    fun onSuccessUpcoming(popularResponse: UpcomingResponse)
    fun onFailureUpcoming(message:String)
}
