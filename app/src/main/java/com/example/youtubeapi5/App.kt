package com.example.youtubeapi5

import android.app.Application
import com.example.youtubeapi5.core.network.RetrofitClient
import com.example.youtubeapi5.repository.Repository

class App : Application(){

    val repository by lazy { Repository() }

    val youTubeApi by lazy { RetrofitClient.create() }

}