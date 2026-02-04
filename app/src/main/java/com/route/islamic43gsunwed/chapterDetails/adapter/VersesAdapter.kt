package com.route.islamic43gsunwed.chapterDetails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic43gsunwed.databinding.ItemVerseBinding

class VersesAdapter(val verses: List<String>? = null) :
    RecyclerView.Adapter<VersesAdapter.VerseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VerseViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemVerseBinding.inflate(inflater, parent, false)
        return VerseViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: VerseViewHolder,
        position: Int
    ) {
        val verse = verses?.get(position)
        holder.bind(verse ?: "", position)
    }

    override fun getItemCount(): Int {
        return verses?.size ?: 0
    }

    class VerseViewHolder(val binding: ItemVerseBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(verse: String, position: Int) {
            binding.verse.text = "$verse [${position + 1}]"
        }
    }
}
