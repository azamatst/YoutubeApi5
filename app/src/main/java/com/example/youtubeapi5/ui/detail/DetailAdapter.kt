package com.example.youtubeapi5.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi5.databinding.ItemVideoBinding
import com.example.youtubeapi5.extension.load
import com.example.youtubeapi5.data.remote.model.Items
import com.example.youtubeapi5.databinding.ItemDetailBinding

class DetailAdapter(private val playlist: ArrayList<Items>) :
    RecyclerView.Adapter<DetailAdapter.ViewHolder>() {
    
/*
    private lateinit var mListener: OnItemClick

    fun setOnItem(listener: OnItemClick) {
        mListener = listener
    }
*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding/*, mListener*/)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(playlist[position])
    }

    override fun getItemCount() = playlist.size

    class ViewHolder(private val binding: ItemDetailBinding/*, private val listener: OnItemClick*/) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(playlist: Items) {
            binding.tvDetailDesc.text =
                playlist.contentDetails.duration
            binding.ivPlaylist.load(playlist.snippet.thumbnails.default.url)
            binding.tvDetailTitle.text = playlist.snippet.title

            /*itemView.setOnClickListener {
                listener.onItem(playlist.id)
            }*/
        }
    }

    interface OnItemClick {
        fun onItem(id: String)
    }
}