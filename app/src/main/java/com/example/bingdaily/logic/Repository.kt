package com.example.bingdaily.logic

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.bingdaily.logic.modal.Image
import com.example.bingdaily.logic.modal.ImageResponse
import com.example.bingdaily.logic.network.BingNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

object Repository {
    fun getImage() = liveData(Dispatchers.IO) {
        val response = BingNetwork.getImage() as ImageResponse
        emit(response.images)
    }
}