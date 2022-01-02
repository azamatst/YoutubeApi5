package com.example.youtubeapi5.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.youtubeapi5.R
import com.example.youtubeapi5.extension.showToast
import com.example.youtubeapi5.ui.playlist.PlaylistActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val a = intent.getStringExtra(PlaylistActivity.PLAYLIST_ID)

        if (a != null) {
            showToast(a)
        }
    }
}