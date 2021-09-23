package com.example.bingdaily.logic.network

import com.example.bingdaily.logic.modal.ImageResponse
import retrofit2.Call
import retrofit2.http.GET

interface ImageService {
    @GET("HPImageArchive.aspx?format=js&idx=0&n=1")
    fun search(): Call<ImageResponse>
}