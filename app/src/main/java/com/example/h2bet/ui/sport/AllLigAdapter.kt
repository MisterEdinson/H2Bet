package com.example.h2bet.ui.sport

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.h2bet.R
import com.example.h2bet.data.network.models.ligs.ValueItem
import com.example.h2bet.databinding.ItemLeagueBinding

class AllLigAdapter(private val navigate: (Int) -> Unit): RecyclerView.Adapter<AllLigAdapter.LigHolder>() {
    class LigHolder(view: View): RecyclerView.ViewHolder(view)

    private var callback = object: DiffUtil.ItemCallback<ValueItem>(){
        override fun areItemsTheSame(oldItem: ValueItem, newItem: ValueItem): Boolean {
            return oldItem.lI == newItem.lI
        }

        override fun areContentsTheSame(oldItem: ValueItem, newItem: ValueItem): Boolean {
            return oldItem.cHIMG == newItem.cHIMG
        }
    }

    var list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LigHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_league, parent, false)
        return LigHolder(view)
    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }

    override fun onBindViewHolder(holder: LigHolder, position: Int) {
        val item = list.currentList[position]
        val binding = ItemLeagueBinding.bind(holder.itemView)

        binding.apply {
            tvLeagueName.text = item.lE
            tvLeagueCountGame.text = item.gC.toString()
        }
        item.lI?.let { binding.imgLeagueDetails.setOnClickListener { navigate(item.lI) } }
    }
}