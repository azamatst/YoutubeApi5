package com.example.youtubeapi5.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi5.BuildConfig.API_KEY
import com.example.youtubeapi5.`object`.Constant
import com.example.youtubeapi5.base.BaseViewModel
import com.example.youtubeapi5.model.Playlist
import com.example.youtubeapi5.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class PlayListViewModel: BaseViewModel() {

    private val youtubeApi = RetrofitClient.create()

    fun getPlayList(): LiveData<Playlist>{
        return createPlayList()
    }

    private fun createPlayList(): LiveData<Playlist> {

        val data = MutableLiveData<Playlist>()

        youtubeApi.getPlayLists(Constant.PART,Constant.CHANNEL_ID,API_KEY)
            .enqueue(object  : retrofit2.Callback<Playlist>{
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful && response.body() != null){
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