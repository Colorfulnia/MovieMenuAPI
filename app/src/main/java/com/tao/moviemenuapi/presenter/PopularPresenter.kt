package com.tao.moviemenuapi.presenter

import com.tao.moviemenuapi.model.Popular.OptCallBackPopular
import com.tao.moviemenuapi.model.Popular.PopularResponse
import com.tao.moviemenuapi.model.VolleyHandler

class PopularPresenter(
    private val volleyHandler:VolleyHandler,
    private val popularView: MVPPopular.PopularView
): MVPPopular.PopularPresenter {
    override fun fetchPopularMovieData() {
        popularView.onLoadPopular(true)
        volleyHandler.makeApiCallPopular(object : OptCallBackPopular{
            override fun onSuccessPopular(popularResponse: PopularResponse) {
                popularView.onLoadPopular(false)
                popularView.setResultPopular(popularResponse)
            }

            override fun onFailurePopular(message: String) {
                popularView.onLoadPopular(false)
                popularView.showErrorPopular(message)
            }
        })
    }
}
