package com.example.h2bet.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.h2bet.R
import com.example.h2bet.databinding.FragmentSettingsBinding
import com.example.h2bet.ui.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.openSettings.observe(viewLifecycleOwner){
            if (it) findNavController().popBackStack()
        }

        binding.apply {
            btnReturn.setOnClickListener { findNavController().popBackStack() }
            incOdds.ltOddsContainer.setOnClickListener {  }
            incTime.ltTimeContainer.setOnClickListener {  }
        }
    }
}