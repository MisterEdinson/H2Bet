package com.example.h2bet.ui.game.mines

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.h2bet.R
import com.example.h2bet.databinding.ItemMinesBinding

class MinesAdapter(
    private val win: (MinesDataGame.MinesModel) -> Unit,
    private val last: (Boolean) -> Unit
) : RecyclerView.Adapter<MinesAdapter.MinesHolder>() {
    class MinesHolder(view: View) : RecyclerView.ViewHolder(view)

    var blockMines = false
    private val callback = object : DiffUtil.ItemCallback<MinesDataGame.MinesModel>() {
        override fun areItemsTheSame(
            oldItem: MinesDataGame.MinesModel,
            newItem: MinesDataGame.MinesModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: MinesDataGame.MinesModel,
            newItem: MinesDataGame.MinesModel
        ): Boolean {
            return (oldItem.select == newItem.select && oldItem.id == newItem.id)
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

        binding.apply {
            imgBgMines.setOnClickListener {
                if (!item.select && !blockMines) {
                    if (item.type) {
                        imgBgMines.setImageResource(R.drawable.item_mine_win)
                        tvMinesCoef.visibility = View.VISIBLE
                        tvMinesCoef.text = item.value.toString()
                        win(item)
                    } else {
                        imgBgMines.setImageResource(R.drawable.item_mine_over)
                        last(true)
                    }
                }
            }
        }
    }
}