package com.example.youtubeapi5.extension

import android.content.Context
import android.widget.Toast

fun Context.showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }