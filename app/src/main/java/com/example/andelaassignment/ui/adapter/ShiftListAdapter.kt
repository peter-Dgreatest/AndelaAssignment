package com.example.andelaassignment.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.andelaassignment.R
import com.example.andelaassignment.databinding.ShiftItemViewBinding
import com.example.andelaassignment.ui.model.ShiftUiModel
import com.example.andelaassignment.ui.adapter.ShiftListAdapter.ShiftViewHolder

class ShiftListAdapter:
    ListAdapter<ShiftUiModel, ShiftViewHolder>(ShiftDiffCallBack()) {

    var mListRef: List<ShiftUiModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShiftViewHolder {
        return ShiftViewHolder.from(parent)
    }

    class ShiftViewHolder private constructor(private val binding: ShiftItemViewBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        fun bind(item: ShiftUiModel) {
            binding.shiftItem = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ShiftViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ShiftItemViewBinding.inflate(layoutInflater, parent, false)
                return ShiftViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ShiftViewHolder, position: Int) {
        var item = getItem(position)
        holder.bind(item)
    }
}

class ShiftDiffCallBack:DiffUtil.ItemCallback<ShiftUiModel>(){
    override fun areItemsTheSame(oldItem: ShiftUiModel, newItem: ShiftUiModel): Boolean {
        return oldItem.displayText==newItem.displayText
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ShiftUiModel, newItem: ShiftUiModel): Boolean {
        return oldItem==newItem
    }

}
