package com.example.youtubeapi5.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi5.App
import com.example.youtubeapi5.BuildConfig
import com.example.youtubeapi5.BuildConfig.API_KEY
import com.example.youtubeapi5.data.remote.model.Playlist
import com.example.youtubeapi5.utils.`object`.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {


    fun createPlayList(): LiveData<Playlist> {
        val data = MutableLiveData<Playlist>()

        App().youTubeApi.getPlayLists(
            Constant.PART,
            Constant.CHANNEL_ID,
            API_KEY,
            Constant.MAX_RESULT
        )
            .enqueue(object : Callback<Playlist> {
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful && response.body() != null) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Playlist>, t: Throwable) {
                    print(t.stackTrace)
                }
            })
        return data
    }

    fun getPlaylistItems(id: String): LiveData<Playlist> {
        val data = MutableLiveData<Playlist>()

        App().youTubeApi.getPlayListItems(Constant.PART, id, Constant.MAX_RESULT, API_KEY).enqueue(object : Callback<Playlist>{
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                if (response.isSuccessful && response.body() != null) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<Playlist>, t: Throwable) {
                print(t.stackTrace)
            }

        })
        return data
    }
}
