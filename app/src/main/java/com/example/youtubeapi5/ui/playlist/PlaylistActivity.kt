package com.example.youtubeapi5.ui.playlist

import android.app.AlertDialog
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi5.base.BaseActivity
import com.example.youtubeapi5.databinding.ActivityPlaylistBinding
import com.example.youtubeapi5.ui.detail.DetailActivity
import com.google.android.material.snackbar.Snackbar

class PlaylistActivity : BaseActivity<PlayListViewModel, ActivityPlaylistBinding>() {
    private lateinit var playlistAdapter: PlaylistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (haveNetwork()) {
            binding.layoutInternet.root.visibility = View.GONE
            binding.recycler.visibility = View.VISIBLE
            val snackbar =
                Snackbar.make(binding.mainLayout, "Internet Found", Snackbar.LENGTH_SHORT)
            snackbar.show()
        } else {
            binding.layoutInternet.root.visibility = View.VISIBLE
            binding.recycler.visibility = View.GONE

            binding.layoutInternet.tryBtn.setOnClickListener {
                restartApp()
            }

//            val builder = AlertDialog.Builder(this)
//            builder.setTitle("App Name")
//            builder.setMessage("Internet not found")
//            builder.setNegativeButton("Okay") { dialogInterface, i -> finish() }
//            builder.setPositiveButton("Try") { dialogInterface, i -> restartApp() }
//            builder.show()
        }


    }

    private fun haveNetwork(): Boolean {
        var haveWifi = false
        var haveMobile = false
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfos = connectivityManager.allNetworkInfo
        for (info in networkInfos) {
            if (info.typeName.equals("WIFI", ignoreCase = true)) if (info.isConnected) haveWifi =
                true
            if (info.typeName.equals(
                    "MOBILE",
                    ignoreCase = true
                )
            ) if (info.isConnected) haveMobile = true
        }
        return haveMobile || haveWifi
    }

    private fun restartApp() {
        startActivity(Intent(applicationContext, PlaylistActivity::class.java))
        finish()
    }


    override fun initView() {
        super.initView()

        viewModel = ViewModelProvider(this).get(PlayListViewModel::class.java)
    }

    override fun initViewModel() {
        super.initViewModel()

        viewModel.getPlayList().observe(this) {
            Log.e("items", "initViewModel: ${it.items}")
            playlistAdapter = PlaylistAdapter(it.items)
            binding.recycler.adapter = playlistAdapter
            playlistAdapter.setOnItem(object : PlaylistAdapter.OnItemClick {
                override fun onItem(id: String) {
                    val intent = Intent(this@PlaylistActivity, DetailActivity::class.java)
                    intent.putExtra(PLAYLIST_ID, id)
                    startActivity(intent)
                }

            })

        }
    }

    override fun inflateVB(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

    companion object {
        const val PLAYLIST_ID = "playlist id key"
    }
}
