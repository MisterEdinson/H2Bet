package com.example.h2bet.ui.game.mines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.h2bet.R
import com.example.h2bet.databinding.FragmentMinesBinding
import com.example.h2bet.ui.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MinesFragment : Fragment() {

    private lateinit var binding: FragmentMinesBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private var gameData = RandomGame()
    private lateinit var adapter: MinesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMinesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        gameData.dataInit()
        adapter.list.submitList(gameData.randomData)

        viewModel.openSettings.observe(viewLifecycleOwner){
            if (it) findNavController().navigate(R.id.action_minesFragment_to_settingsFragment)
        }

        binding.apply {
            btnReturn.setOnClickListener { findNavController().popBackStack() }
            btnAgain.setOnClickListener {  }
        }
    }

    private fun initAdapter() {
        adapter = MinesAdapter()
        binding.rvMines.adapter = adapter
    }
}