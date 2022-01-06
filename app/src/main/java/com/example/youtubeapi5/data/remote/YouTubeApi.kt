package com.example.youtubeapi5.data.remote

import com.example.youtubeapi5.data.remote.model.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {
    @GET("playlists")
    fun getPlayLists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") key: String,
        @Query("maxResults") maxResult: Int,
    ): Call<Playlist>

    @GET("playlistItems")
    fun getPlayListItems(
        @Query("part") part: String,
        @Query("playlistId") playlistId: String,
        @Query("maxResults") maxResult: Int,
        @Query("key") key: String
    ): Call<Playlist>
}