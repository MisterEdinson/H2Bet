package com.example.h2bet.ui.sport.liga

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.h2bet.R
import com.example.h2bet.data.Constants.Companion.URL_IMAGE
import com.example.h2bet.data.network.models.league.GItem
import com.example.h2bet.databinding.ItemLeagueDayItemBinding
import com.example.h2bet.databinding.ItemLeagueDayMatchesBinding
import com.example.h2bet.utils.loadImage
import com.example.h2bet.utils.visibleIf
import kotlin.random.Random

class CompetitionAdapter: RecyclerView.Adapter<CompetitionAdapter.LigHolder>() {
    class LigHolder(view: View) : RecyclerView.ViewHolder(view)

    private val callback = object : DiffUtil.ItemCallback<GItem>(){
        override fun areItemsTheSame(oldItem: GItem, newItem: GItem): Boolean {
            return newItem == oldItem
        }

        override fun areContentsTheSame(oldItem: GItem, newItem: GItem): Boolean {
            return newItem.i == oldItem.i
        }
    }

    var list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LigHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_league_day_item, parent, false)
        return LigHolder(view)
    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }

    override fun onBindViewHolder(holder: LigHolder, position: Int) {
        val item = list.currentList[position]
        val binding = ItemLeagueDayItemBinding.bind(holder.itemView)

        binding.apply {
            imgTeam1.loadImage("${URL_IMAGE}${item.o1IMG?.get(0)}")
            imgTeam2.loadImage("${URL_IMAGE}${item.o2IMG?.get(0)}")
            tvTeam1.text = item.o1E
            tvTeam2.text = item.o2E
            tvTotalWin1.text = randInt().toString()
            tvTotalWin2.text = randInt().toString()
            tvTotalDraw.text = randInt().toString()
        }
    }

    private fun randInt(): Double{
        return (Random.nextInt(10, 31) / 10.0)
    }
}