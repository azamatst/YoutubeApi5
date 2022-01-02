package com.example.youtubeapi5.ui.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi5.databinding.ItemVideoBinding
import com.example.youtubeapi5.extension.load
import com.example.youtubeapi5.model.Items
import com.example.youtubeapi5.model.Playlist

class PlaylistAdapter(private val playlist: ArrayList<Items>) :
    RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {
    private lateinit var mListener: OnItemClick

    fun setOnItem(listener: OnItemClick) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(playlist[position])
    }

    override fun getItemCount() = playlist.size

    class ViewHolder(private val binding: ItemVideoBinding, private val listener: OnItemClick) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(playlist: Items) {
            binding.tvDesc.text =
                (playlist.contentDetails.itemCount.toString() + " video series")
            binding.ivPlaylist.load(playlist.snippet.thumbnails.default.url)
            binding.tvTitle.text = playlist.snippet.title

            itemView.setOnClickListener {
                listener.onItem(playlist.id)
            }
        }
    }

    interface OnItemClick {
        fun onItem(id: String)
    }
}