package com.example.h2bet.ui.settings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.h2bet.R
import com.example.h2bet.databinding.ItemSettingsConfigBinding

class OddsAdapter(private val select: (SettingsDataModel) -> Unit): RecyclerView.Adapter<OddsAdapter.OddsHolder>() {
    class OddsHolder(view: View) : RecyclerView.ViewHolder(view)

    private val callback = object: DiffUtil.ItemCallback<SettingsDataModel>(){
        override fun areItemsTheSame(
            oldItem: SettingsDataModel,
            newItem: SettingsDataModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: SettingsDataModel,
            newItem: SettingsDataModel
        ): Boolean {
            return oldItem.title == newItem.title
        }
    }

    val list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OddsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_settings_config, parent, false)
        return OddsHolder(view)
    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }

    override fun onBindViewHolder(holder: OddsHolder, position: Int) {
        val item = list.currentList[position]
        val binding = ItemSettingsConfigBinding.bind(holder.itemView)
        binding.tvConfigItem.text = item.title
        binding.tvConfigItem.setOnClickListener {
            select(item)
        }
    }
}