package com.streaming.android.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.streaming.android.data.model.Conteudo
import com.streaming.android.databinding.ItemConteudoBinding

class ConteudoAdapter(
    private val onItemClick: (Conteudo) -> Unit
) : ListAdapter<Conteudo, ConteudoAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemConteudoBinding.inflate(
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
        private val binding: ItemConteudoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(conteudo: Conteudo) {
            binding.apply {
                tituloText.text = conteudo.titulo
                descricaoText.text = conteudo.descricao
                criadorText.text = conteudo.criador?.canalNome ?: "Desconhecido"
                duracaoText.text = formatarDuracao(conteudo.duracaoSeg)
                
                // Placeholder para thumbnail
                Glide.with(root.context)
                    .load("https://via.placeholder.com/400x225/6200EE/FFFFFF?text=${conteudo.titulo.take(1)}")
                    .centerCrop()
                    .into(thumbnailImage)
                
                root.setOnClickListener {
                    onItemClick(conteudo)
                }
            }
        }

        private fun formatarDuracao(segundos: Int): String {
            val horas = segundos / 3600
            val minutos = (segundos % 3600) / 60
            val segs = segundos % 60
            
            return if (horas > 0) {
                String.format("%d:%02d:%02d", horas, minutos, segs)
            } else {
                String.format("%d:%02d", minutos, segs)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Conteudo>() {
        override fun areItemsTheSame(oldItem: Conteudo, newItem: Conteudo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Conteudo, newItem: Conteudo): Boolean {
            return oldItem == newItem
        }
    }
}


