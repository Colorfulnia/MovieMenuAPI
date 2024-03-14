package com.tao.moviemenuapi.model

import android.content.Context
import com.android.volley.toolbox.Volley
import com.tao.moviemenuapi.model.NowPlaying.OptCallBackNowPlaying
import com.tao.moviemenuapi.model.Popular.OptCallBackPopular
import com.tao.moviemenuapi.model.Upcoming.OptCallBackUpcoming

class VolleyHandler(private val context: Context) {
    private  val requestQueue by lazy{ Volley.newRequestQueue(context)}

    fun makeApiCallNowPlaying(callBack1:OptCallBackNowPlaying){
        val
    }

    fun makeApiCallPopular(callBack2:OptCallBackPopular){

    }

    fun makeApiCallUpcoming(callBack3:OptCallBackUpcoming){

    }
}