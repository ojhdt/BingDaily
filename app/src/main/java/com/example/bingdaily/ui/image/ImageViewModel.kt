package com.example.bingdaily.ui.image

import android.util.Log
import androidx.lifecycle.*
import com.example.bingdaily.logic.Repository
import com.example.bingdaily.logic.modal.Image
import com.example.bingdaily.logic.modal.ImageData
import com.example.bingdaily.logic.modal.ImageResponse

class ImageViewModel : ViewModel() {
    private val tempLiveData = MutableLiveData<ImageResponse>()

    val imageResponseLiveData: LiveData<List<Image>> = Transformations.switchMap(tempLiveData) {
        Repository.getImage()
    }

    val imageLiveData: LiveData<List<ImageData>> =
        Transformations.map(imageResponseLiveData) { images ->
            Log.d("image", "fun call")
            val list = ArrayList<ImageData>()
            images.forEach {
                list.add(
                    ImageData(
                        "https://cn.bing.com" + it.url,
                        "Title",
                        it.copyright
                    )
                )
            }
            list
        }

    fun refresh() {
        tempLiveData.value = tempLiveData.value
    }
}