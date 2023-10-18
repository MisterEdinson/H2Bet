package com.example.h2bet.ui.sport

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.h2bet.R
import com.example.h2bet.databinding.FragmentSportBinding
import com.example.h2bet.ui.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SportFragment : Fragment() {

    private lateinit var binding: FragmentSportBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private var adapterLig: AllLigAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSportBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        viewModel.allLigData.observe(viewLifecycleOwner){
            Log.d("http-logging-response", it.toString())
            adapterLig?.list?.submitList(it)
        }

        viewModel.openSettings.observe(viewLifecycleOwner){
            if (it) findNavController().navigate(R.id.action_sportFragment_to_settingsFragment)
        }

        binding.apply {
            btnGames.setOnClickListener { findNavController().popBackStack() }
        }
    }

    private fun initAdapter() {
        adapterLig = AllLigAdapter()
        binding.rvLig.adapter = adapterLig
    }
}