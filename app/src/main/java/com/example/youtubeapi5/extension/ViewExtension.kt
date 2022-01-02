package com.example.youtubeapi5.extension

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide

var ProgressBar.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.INVISIBLE
    }

fun ImageView.load(url:String){
    Glide.with(this).load(url).into(this)
}