package com.example.bingdaily.logic.modal

data class ImageResponse(val images: List<Image>)

data class Image(
    val startdate: String,
    val fullstartdate: String,
    val enddate: String,
    val url: String,
    val urlbase: String,
    val copyright: String,
    val copyrightlink: String,
)