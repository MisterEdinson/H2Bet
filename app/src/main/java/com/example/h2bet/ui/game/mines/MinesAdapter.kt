package com.example.h2bet.ui.game.mines

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.h2bet.R
import com.example.h2bet.databinding.ItemMinesBinding

class MinesAdapter : RecyclerView.Adapter<MinesAdapter.MinesHolder>() {
    class MinesHolder(view: View) : RecyclerView.ViewHolder(view)

    private val callback = object: DiffUtil.ItemCallback<MinesDataGame.MinesModel>(){
        override fun areItemsTheSame(
            oldItem: MinesDataGame.MinesModel,
            newItem: MinesDataGame.MinesModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MinesDataGame.MinesModel,
            newItem: MinesDataGame.MinesModel
        ): Boolean {
            return oldItem.select == newItem.select
        }
    }

    var list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MinesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mines, parent, false)
        return MinesHolder(view)
    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }

    override fun onBindViewHolder(holder: MinesHolder, position: Int) {
        val item = list.currentList[position]
        val binding = ItemMinesBinding.bind(holder.itemView)
    }
}