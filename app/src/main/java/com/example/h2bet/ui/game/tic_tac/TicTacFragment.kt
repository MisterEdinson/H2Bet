package com.example.h2bet.ui.game.tic_tac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.h2bet.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TicTacFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tic_tac, container, false)
    }
}