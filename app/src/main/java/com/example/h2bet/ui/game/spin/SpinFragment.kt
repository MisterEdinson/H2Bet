package com.example.h2bet.ui.game.spin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.h2bet.R
import com.example.h2bet.databinding.FragmentSpinBinding
import com.example.h2bet.ui.SharedViewModel
import com.example.h2bet.utils.animate.Rotate
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
class SpinFragment : Fragment() {

    private lateinit var binding: FragmentSpinBinding
    private var win : MutableLiveData<Int> = MutableLiveData(0)
    private val viewModel: SharedViewModel by activityViewModels()
    private var blockBtnSpin: Boolean = false
    private var winResult: Float = 0.0F
    private var totalWin = 250

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpinBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            tvScore.text = "Score: $totalWin"
        }

        binding.apply {
            btnSpin.setOnClickListener {
                if (!blockBtnSpin) startAnimation(imgFortune)
            }
            btnReturn.setOnClickListener { findNavController().popBackStack() }
        }

        viewModel.openSettings.observe(viewLifecycleOwner){
            if (it) findNavController().navigate(R.id.action_spinFragment_to_settingsFragment)
        }
    }

    private fun startAnimation(view: View) {
        blockBtnSpin = true
        Rotate({ start -> startAnimate(blockBtnSpin)},{ end -> endAnimate(end)}).rotateWheel(view)
    }

    private fun startAnimate(block: Boolean){
        blockBtnSpin = block
    }

    private fun endAnimate(result:Float){
        blockBtnSpin = false
        totalWin += Random.nextInt(10, 70)
        update()
        //Toast.makeText(context, result.toString(), Toast.LENGTH_SHORT).show()
        //win.value = RandomWin().math(rate.value!!)
    }

    private fun update(){
        binding.tvScore.text = "Score: $totalWin"
    }
}