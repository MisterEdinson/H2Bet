package com.example.h2bet.ui.sport.liga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView.ItemAnimator
import com.example.h2bet.R
import com.example.h2bet.data.network.models.league.GItem
import com.example.h2bet.data.network.models.league.Value
import com.example.h2bet.databinding.FragmentSportLigaBinding
import com.example.h2bet.ui.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SportLigaFragment : Fragment() {

    private lateinit var binding: FragmentSportLigaBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private var adapter: CompetitionAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSportLigaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arg = arguments?.getInt("leagueId")
        initAdapter()
        if (arg != null) viewModel.getSelectLig(arg)
        viewModel.selectChamp.observe(viewLifecycleOwner) {
            binding.tvLeagueLabel.text = it?.lE
            val data = it?.g
            val dataUpd = mutableListOf<GItem?>()
            data?.forEachIndexed { index, gItem ->
                if (gItem?.o1IMG?.get(0) != "defaultlogo.png") {
                    dataUpd.add(gItem)
                }
            }
            adapter?.list?.submitList(dataUpd)
        }
        binding.apply {
            imgReturn.setOnClickListener { findNavController().popBackStack() }
        }
    }

    private fun initAdapter() {
        adapter = CompetitionAdapter()
        binding.rvGameDay.adapter = adapter
        binding.rvGameDay.itemAnimator = DefaultItemAnimator()
    }
}