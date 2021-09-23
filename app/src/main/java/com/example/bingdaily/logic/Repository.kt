package com.example.bingdaily.logic

import androidx.lifecycle.liveData
import com.example.bingdaily.logic.modal.ImageResponse
import com.example.bingdaily.logic.network.BingNetwork

object Repository {
    fun getImage() = liveData {
        val result = BingNetwork.getImage()
        emit(Result.success(result))
    }
}