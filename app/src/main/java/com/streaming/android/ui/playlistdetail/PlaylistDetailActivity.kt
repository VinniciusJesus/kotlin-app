package com.streaming.android.ui.playlistdetail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.streaming.android.data.repository.MockRepository
import com.streaming.android.databinding.ActivityPlaylistDetailBinding
import com.streaming.android.ui.adapter.ConteudoAdapter
import com.streaming.android.ui.player.PlayerActivity
import kotlinx.coroutines.launch

class PlaylistDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlaylistDetailBinding
    private lateinit var adapter: ConteudoAdapter
    private val repository = MockRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaylistDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val playlistId = intent.getIntExtra("playlist_id", -1)
        val playlistTitulo = intent.getStringExtra("playlist_titulo") ?: "Playlist"

        supportActionBar?.title = playlistTitulo
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupRecyclerView()
        loadPlaylist(playlistId)
    }

    private fun setupRecyclerView() {
        adapter = ConteudoAdapter { conteudo ->
            val intent = Intent(this, PlayerActivity::class.java).apply {
                putExtra("conteudo_id", conteudo.id)
                putExtra("titulo", conteudo.titulo)
                putExtra("url_midia", conteudo.urlMidia)
                putExtra("descricao", conteudo.descricao)
            }
            startActivity(intent)
        }
        
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun loadPlaylist(playlistId: Int) {
        lifecycleScope.launch {
            val playlist = repository.getPlaylist(playlistId)
            if (playlist != null) {
                binding.tituloText.text = playlist.titulo
                binding.descricaoText.text = playlist.descricao ?: "Sem descrição"
                binding.quantidadeText.text = "${playlist.itens.size} vídeos"
                
                val conteudos = playlist.itens.mapNotNull { it.conteudo }
                adapter.submitList(conteudos)
            } else {
                binding.emptyState.visibility = View.VISIBLE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}


