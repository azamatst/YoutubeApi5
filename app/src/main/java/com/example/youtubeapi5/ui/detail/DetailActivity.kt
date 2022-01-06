package com.example.youtubeapi5.ui.detail

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi5.core.ui.BaseActivity
import com.example.youtubeapi5.data.remote.model.Playlist
import com.example.youtubeapi5.databinding.ActivityDetailBinding
import com.example.youtubeapi5.ui.playlist.PlaylistActivity

class DetailActivity : BaseActivity<DetailViewModel, ActivityDetailBinding>() {

    private lateinit var adapter: DetailAdapter

    override fun initView() {
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
    }

    override fun initListener() {

    }

    override fun initViewModel() {
        val id = intent.getStringExtra(PlaylistActivity.PLAYLIST_ID)
        val desc = intent.getStringExtra(PlaylistActivity.PLAYLIST_DESC)
        val title = intent.getStringExtra(PlaylistActivity.PLAYLIST_TITLE)

//        Log.e("myid", "initViewModel: $id")
        if (id != null && desc != null && title != null) {
            viewModel.getPlaylistItems(id).observe(this) {
                adapter = DetailAdapter(it.items)
                binding.detailVideos.adapter = adapter
//                Log.e("playlistItems", "initView: ${it.items}")
                binding.tvTitle.text = title
//                binding.title3.text = title
                binding.tvDescription.text = desc
                Log.e("desc", "desc: $title $desc ")
            }
        }
    }

    override fun inflateVB(inflater: LayoutInflater): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }
}