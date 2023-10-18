package com.example.h2bet.ui.game.mines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
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
    private var totalWin = 250

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
        binding.tvScore.text = "Score: $totalWin"
        adapter.list.submitList(gameData.randomData)

        viewModel.openSettings.observe(viewLifecycleOwner){
            if (it) findNavController().navigate(R.id.action_minesFragment_to_settingsFragment)
        }

        binding.apply {
            btnReturn.setOnClickListener { findNavController().popBackStack() }
            btnAgain.setOnClickListener { restartMines() }
        }
    }

    private fun initAdapter() {
        adapter = MinesAdapter({win -> gameWin(win)}, {last -> gameOver()})
        binding.rvMines.adapter = adapter
        binding.rvMines.itemAnimator = DefaultItemAnimator()
    }

    private fun gameWin(win: MinesDataGame.MinesModel){
        totalWin = (totalWin * win.value).toInt()
        binding.tvScore.text = "Score: $totalWin"
    }

    private fun gameOver(){
        Toast.makeText(context, "Boom!!!", Toast.LENGTH_LONG).show()
        totalWin = (totalWin / 2)
        binding.tvScore.text = "Score: $totalWin"
        adapter.blockMines = true
    }

    private fun restartMines(){
        gameData = RandomGame()
        adapter.list.submitList(emptyList())
        gameData.dataInit()
        adapter.list.submitList(gameData.randomData)
        adapter.blockMines = false
        adapter.notifyDataSetChanged()
    }
}