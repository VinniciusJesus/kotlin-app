package com.streaming.android.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.streaming.android.data.model.Playlist
import com.streaming.android.databinding.ItemPlaylistBinding

class PlaylistAdapter(
    private val onItemClick: (Playlist) -> Unit = {}
) : ListAdapter<Playlist, PlaylistAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPlaylistBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemPlaylistBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(playlist: Playlist) {
            binding.apply {
                tituloText.text = playlist.titulo
                descricaoText.text = playlist.descricao ?: "Sem descrição"
                quantidadeText.text = "${playlist.itens.size} vídeos"
                
                if (playlist.isPublica) {
                    publicaBadge.visibility = android.view.View.VISIBLE
                } else {
                    publicaBadge.visibility = android.view.View.GONE
                }
                
                root.setOnClickListener {
                    onItemClick(playlist)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Playlist>() {
        override fun areItemsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
            return oldItem == newItem
        }
    }
}


