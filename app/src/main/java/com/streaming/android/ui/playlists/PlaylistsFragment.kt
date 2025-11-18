package com.streaming.android.ui.playlists

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.streaming.android.data.repository.MockRepository
import com.streaming.android.databinding.FragmentPlaylistsBinding
import com.streaming.android.ui.adapter.PlaylistAdapter
import com.streaming.android.ui.playlistdetail.PlaylistDetailActivity
import kotlinx.coroutines.launch

class PlaylistsFragment : Fragment() {

    private var _binding: FragmentPlaylistsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: PlaylistAdapter
    private val repository = MockRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlaylistsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        loadPlaylists()
    }

    private fun setupRecyclerView() {
        adapter = PlaylistAdapter { playlist ->
            val intent = Intent(requireContext(), PlaylistDetailActivity::class.java).apply {
                putExtra("playlist_id", playlist.id)
                putExtra("playlist_titulo", playlist.titulo)
            }
            startActivity(intent)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    private fun loadPlaylists() {
        lifecycleScope.launch {
            val playlists = repository.getPlaylists()
            adapter.submitList(playlists)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


