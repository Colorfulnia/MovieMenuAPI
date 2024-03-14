package com.tao.moviemenuapi.model.Popular

interface OptCallBackPopular {
    fun onSuccessPopular(popularResponse: PopularResponse)
    fun onFailurePopular(message:String)
}
