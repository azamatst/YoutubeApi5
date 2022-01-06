package com.example.youtubeapi5.ui.detail

import androidx.lifecycle.LiveData
import com.example.youtubeapi5.App
import com.example.youtubeapi5.core.ui.BaseViewModel
import com.example.youtubeapi5.data.remote.model.Playlist

class DetailViewModel : BaseViewModel() {

    fun getPlaylistItems(id: String): LiveData<Playlist> {
        return App().repository.getPlaylistItems(id)
    }
}