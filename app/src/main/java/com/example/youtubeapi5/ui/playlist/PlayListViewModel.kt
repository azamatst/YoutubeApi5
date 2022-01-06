package com.example.youtubeapi5.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi5.App
import com.example.youtubeapi5.BuildConfig.API_KEY
import com.example.youtubeapi5.utils.`object`.Constant
import com.example.youtubeapi5.core.ui.BaseViewModel
import com.example.youtubeapi5.data.remote.model.Playlist
import com.example.youtubeapi5.core.network.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class PlayListViewModel: BaseViewModel() {


    fun getPlayList(): LiveData<Playlist>{
        return App().repository.createPlayList()

    }



}