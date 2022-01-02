package com.example.youtubeapi5.remote

import com.example.youtubeapi5.model.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {
    @GET("playlists")
    fun getPlayLists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") key: String,
    ): Call<Playlist>
}