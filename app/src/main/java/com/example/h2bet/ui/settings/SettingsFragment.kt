package com.example.h2bet.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
    private var indicatorOdds = true
    private var indicatorTime = true
    private var adapterOdds: OddsAdapter? = null
    private var adapterTime: OddsAdapter? = null
    private val oddsData = listOf(
        SettingsDataModel(0, "Decimal"),
        SettingsDataModel(1, "Fractional"),
        SettingsDataModel(2, "American"),
        SettingsDataModel(3, "HongKong"),
        SettingsDataModel(4, "Malay"),
        SettingsDataModel(5, "Indo"),
    )
    private val timeData = listOf(
        SettingsDataModel(6, "24h"),
        SettingsDataModel(7, "12h"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()

        adapterOdds?.list?.submitList(oddsData)
        adapterTime?.list?.submitList(timeData)

        viewModel.openSettings.observe(viewLifecycleOwner) {
            if (it) findNavController().popBackStack()
        }

        binding.apply {
            btnReturn.setOnClickListener { findNavController().popBackStack() }
            incOdds.ltOddsContainer.setOnClickListener { open(1) }
            incTime.ltTimeContainer.setOnClickListener { open(2) }
        }
    }

    private fun initAdapter() {
        adapterOdds = OddsAdapter{ select -> selectItem(select) }
        adapterTime = OddsAdapter{ select -> selectItem(select) }
        binding.apply {
            incOdds.rvOdds.adapter = adapterOdds
            incTime.rvTime.adapter = adapterTime
        }
    }

    private fun open(status: Int) {
        when (status) {
            1 -> {
                if (indicatorOdds) {
                    openOdds()
                } else {
                    closeOdds()
                }
                indicatorOdds = !indicatorOdds
            }

            2 -> {
                if (indicatorTime) {
                    openTime()
                } else {
                    closeTime()
                }
                indicatorTime = !indicatorTime
            }
        }
    }

    private fun openOdds() {
        binding.incOdds.rvOdds.visibility = View.VISIBLE
    }

    private fun openTime() {
        binding.incTime.rvTime.visibility = View.VISIBLE
    }

    private fun closeOdds() {
        binding.incOdds.rvOdds.visibility = View.GONE
    }

    private fun closeTime() {
        binding.incTime.rvTime.visibility = View.GONE
    }

    private fun selectItem(item: SettingsDataModel) {
        //Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
        if(item.id > 5){
            binding.incTime.tvTimeFormat.text = item.title
            closeTime()
        }else{
            binding.incOdds.tvTypeOdds.text = item.title
            closeOdds()
        }
    }
}