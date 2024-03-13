package com.tao.moviemenuapi.presenter


import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tao.moviemenuapi.model.PopularMovie.PopularMovie
import com.tao.moviemenuapi.view.PopularFragment

import org.json.JSONObject


class PopularPresenter(private val view: PopularFragment) {

    private fun getPopularMovies() {
        val queue = Volley.newRequestQueue(context)
        val url = "Your API URL"

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                parseMovies(response)
            },
            { error ->

            }
        )

        queue.add(jsonObjectRequest)
    }

    private fun parseMovies(jsonObject: JSONObject) {
        val moviesArray = jsonObject.getJSONArray("results")
        val moviesType = object : TypeToken<List<PopularMovie>>() {}.type
        val movies: List<PopularMovie> = Gson().fromJson(moviesArray.toString(), moviesType)

        view.setMovies(movies)
    }
}
