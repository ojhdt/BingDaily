package com.example.bingdaily.ui.image

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.bingdaily.logic.Repository
import com.example.bingdaily.logic.modal.ImageResponse

class ImageViewModal : ViewModel() {
    private val searchLiveData = MutableLiveData<ImageResponse>()

    val imageList = ArrayList<ImageResponse>()

    val imageLiveData = Transformations.switchMap(searchLiveData) {
        Repository.getImage()
    }

    fun refresh() {
        searchLiveData.value = searchLiveData.value
    }
}