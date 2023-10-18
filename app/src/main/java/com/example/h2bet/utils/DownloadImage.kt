package com.example.h2bet.utils

import android.view.View
import android.widget.ImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.h2bet.R

fun ImageView.loadImage(imgUrl: String) {
    val imageLoader = ImageLoader.Builder(this.context)
        .componentRegistry { add(SvgDecoder(this@loadImage.context)) }
        .build()

    val request = ImageRequest.Builder(this.context)
        .crossfade(true)
        .crossfade(100)
        .error(R.drawable.icon)
        .data(imgUrl)
        .target(this)
        .build()
    imageLoader.enqueue(request)
}

fun View?.visibleIf(isVisible: Boolean){
    this?.visibility = if(isVisible){
        View.VISIBLE
    }else{
        View.GONE
    }
}