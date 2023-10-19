package com.example.h2bet.ui.game.tic_tac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.h2bet.R
import com.example.h2bet.databinding.FragmentTicTacBinding
import com.example.h2bet.ui.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
class TicTacFragment : Fragment() {

    private lateinit var binding: FragmentTicTacBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private var dataUser = mutableListOf<TicTacGameModel>()
    private var blockGame = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTicTacBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            fieldTicTac.itemTic1.setOnClickListener { runGame(1, fieldTicTac.itemTic1) }
            fieldTicTac.itemTic2.setOnClickListener { runGame(2, fieldTicTac.itemTic2) }
            fieldTicTac.itemTic3.setOnClickListener { runGame(3, fieldTicTac.itemTic3) }
            fieldTicTac.itemTic4.setOnClickListener { runGame(4, fieldTicTac.itemTic4) }
            fieldTicTac.itemTic5.setOnClickListener { runGame(5, fieldTicTac.itemTic5) }
            fieldTicTac.itemTic6.setOnClickListener { runGame(6, fieldTicTac.itemTic6) }
            fieldTicTac.itemTic7.setOnClickListener { runGame(7, fieldTicTac.itemTic7) }
            fieldTicTac.itemTic8.setOnClickListener { runGame(8, fieldTicTac.itemTic8) }
            fieldTicTac.itemTic9.setOnClickListener { runGame(9, fieldTicTac.itemTic9) }

            btnReturn.setOnClickListener { findNavController().popBackStack() }
            btnAgain.setOnClickListener { restartGame() }
        }

        viewModel.openSettings.observe(viewLifecycleOwner){
            if (it) findNavController().navigate(R.id.action_ticTacFragment_to_settingsFragment)
        }
    }

    private fun runGame(select: Int, view: View) {

        if (!checkSelect(select) && !blockGame) {
            view.setBackgroundResource(R.drawable.tac)
            dataUser.add(TicTacGameModel(select, 1))
            if (dataUser.size < 8) {
                if (dataUser.size > 4) {
                    if (CheckGameWin(dataUser).checkWin(1) == 3) {
                        blockGame()
                        Toast.makeText(context, "WIN!", Toast.LENGTH_SHORT).show()
                    }
                }
                if(!blockGame) gameBot()
            } else {
                if (CheckGameWin(dataUser).checkWin(1) == 3) {
                    blockGame()
                    Toast.makeText(context, "WIN!", Toast.LENGTH_SHORT).show()
                } else {
                    blockGame()
                    Toast.makeText(context, "Draw", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun gameBot() {
        var selectBot = Random.nextInt(1, 9)
        while (checkSelect(selectBot)) {
            selectBot = Random.nextInt(1, 9)
        }
        binding.fieldTicTac.apply {
            when (selectBot) {
                1 -> { itemTic1.setBackgroundResource(R.drawable.toc) }
                2 -> { itemTic2.setBackgroundResource(R.drawable.toc) }
                3 -> { itemTic3.setBackgroundResource(R.drawable.toc) }
                4 -> { itemTic4.setBackgroundResource(R.drawable.toc) }
                5 -> { itemTic5.setBackgroundResource(R.drawable.toc) }
                6 -> { itemTic6.setBackgroundResource(R.drawable.toc) }
                7 -> { itemTic7.setBackgroundResource(R.drawable.toc) }
                8 -> { itemTic8.setBackgroundResource(R.drawable.toc) }
                9 -> { itemTic9.setBackgroundResource(R.drawable.toc) }
            }
        }

        dataUser.add(TicTacGameModel(selectBot, 0))
        if (CheckGameWin(dataUser).checkWin(0) == 3) {
            blockGame()
            Toast.makeText(context, "LOST!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkSelect(searchId: Int): Boolean {
        var search = false
        for (num in dataUser) {
            if (num.id == searchId) {
                search = true
                break
            }
        }
        return search
    }

    private fun blockGame() {
        blockGame = true
    }

    private fun unblockGame() {
        blockGame = false
    }

    private fun restartGame() {
        unblockGame()
        dataUser = mutableListOf()
        binding.fieldTicTac.apply {
            itemTic1.setBackgroundResource(0)
            itemTic2.setBackgroundResource(0)
            itemTic3.setBackgroundResource(0)
            itemTic4.setBackgroundResource(0)
            itemTic5.setBackgroundResource(0)
            itemTic6.setBackgroundResource(0)
            itemTic7.setBackgroundResource(0)
            itemTic8.setBackgroundResource(0)
            itemTic9.setBackgroundResource(0)
        }
    }
}