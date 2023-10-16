package com.example.h2bet.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.h2bet.R
import com.example.h2bet.databinding.FragmentHomeBinding
import com.example.h2bet.ui.SharedViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.openSettings.observe(viewLifecycleOwner){
            if (it) findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }

        binding.apply {
            btnGamesHome.setOnClickListener { }
            btnSportHome.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_sportFragment) }
            btnGameSpin.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_spinFragment) }
            btnGameMines.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_minesFragment) }
            btnGameTicToc.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_ticTacFragment) }
        }
    }
}