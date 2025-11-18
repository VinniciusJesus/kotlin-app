package com.streaming.android.ui.feed

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.streaming.android.data.repository.MockRepository
import com.streaming.android.databinding.FragmentFeedBinding
import com.streaming.android.ui.adapter.ConteudoAdapter
import com.streaming.android.ui.player.PlayerActivity
import kotlinx.coroutines.launch

class FeedFragment : Fragment() {

    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ConteudoAdapter
    private val repository = MockRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        loadConteudos()
    }

    private fun setupRecyclerView() {
        adapter = ConteudoAdapter { conteudo ->
            val intent = Intent(requireContext(), PlayerActivity::class.java).apply {
                putExtra("conteudo_id", conteudo.id)
                putExtra("titulo", conteudo.titulo)
                putExtra("url_midia", conteudo.urlMidia)
                putExtra("descricao", conteudo.descricao)
            }
            startActivity(intent)
        }
        
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    private fun loadConteudos() {
        lifecycleScope.launch {
            val conteudos = repository.getConteudos()
            adapter.submitList(conteudos)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


