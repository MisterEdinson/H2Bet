package com.example.h2bet.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.h2bet.R
import com.example.h2bet.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnGames.setOnClickListener { }
            btnSport.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_sportFragment) }
            btnGameSpin.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_spinFragment) }
            btnGameMines.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_minesFragment) }
            btnGameTicToc.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_ticTacFragment) }
        }
    }
}