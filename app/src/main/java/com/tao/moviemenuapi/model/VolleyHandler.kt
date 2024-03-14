package com.tao.moviemenuapi.model

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tao.moviemenuapi.model.Constant.BASE_URL_NOWPLAYING
import com.tao.moviemenuapi.model.Constant.BASE_URL_POPULAR
import com.tao.moviemenuapi.model.Constant.BASE_URL_UPCOMING
import com.tao.moviemenuapi.model.NowPlaying.NowPlayingResponse
import com.tao.moviemenuapi.model.NowPlaying.OptCallBackNowPlaying
import com.tao.moviemenuapi.model.Popular.OptCallBackPopular
import com.tao.moviemenuapi.model.Popular.PopularResponse
import com.tao.moviemenuapi.model.Upcoming.OptCallBackUpcoming
import com.tao.moviemenuapi.model.Upcoming.UpcomingResponse

class VolleyHandler(private val context: Context) {
    private  val requestQueue by lazy{ Volley.newRequestQueue(context)}

    fun makeApiCallNowPlaying(callBack1:OptCallBackNowPlaying){
        val stringRequest = StringRequest(Request.Method.GET,BASE_URL_NOWPLAYING,{
            val typeToken = object: TypeToken<NowPlayingResponse>(){}
            val response = Gson().fromJson(it,typeToken)

            if (response.total_pages != null){
                Log.i("tag","${response.total_pages}")
                callBack1.onSuccessNowplaying(response)
            }else{
                Log.i("tag","${it.toString()}")
                callBack1.onFailureNowplaying("Error")
            }
        },{
            Log.i("tag","${it.toString()}")
            callBack1.onFailureNowplaying(it.message.toString())
        })
        requestQueue.add(stringRequest)
    }

    fun makeApiCallPopular(callBack2:OptCallBackPopular){
        val stringRequest = StringRequest(Request.Method.GET, BASE_URL_POPULAR,{
            val typeToken = object:TypeToken<PopularResponse>(){}
            val response = Gson().fromJson(it,typeToken)

            if (response.total_pages != null){
                Log.i("tag","${response.total_pages}")
                callBack2.onSuccessPopular(response)
            }else{
                Log.i("tag","${it.toString()}")
                callBack2.onFailurePopular("Error")
            }
        },{
            Log.i("tag","${it.toString()}")
            callBack2.onFailurePopular(it.message.toString())
        })
        requestQueue.add(stringRequest)
    }

    fun makeApiCallUpcoming(callBack3:OptCallBackUpcoming) {
        val stringRequest = StringRequest(Request.Method.GET, BASE_URL_UPCOMING, {
            val typeToken = object : TypeToken<UpcomingResponse>() {}
            val response = Gson().fromJson(it, typeToken)

            if (response.total_pages != null) {
                Log.i("tag", "${response.total_pages}")
                callBack3.onSuccessUpcoming(response)
            } else {
                Log.i("tag", "${it.toString()}")
                callBack3.onFailureUpcoming("Error")
            }
        }, {
            Log.i("tag", "${it.toString()}")
            callBack3.onFailureUpcoming(it.message.toString())
        })
        requestQueue.add(stringRequest)
    }
}