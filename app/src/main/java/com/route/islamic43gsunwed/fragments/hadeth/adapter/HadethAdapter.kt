package com.route.islamic43gsunwed.fragments.hadeth.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic43gsunwed.databinding.ItemHadethBinding
import com.route.islamic43gsunwed.fragments.hadeth.model.Hadeth

class HadethAdapter(val hadethList: List<Hadeth>? = null) :
    RecyclerView.Adapter<HadethAdapter.HadethViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HadethViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemHadethBinding.inflate(inflater, parent, false)
        return HadethViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: HadethViewHolder,
        position: Int
    ) {
        val hadeth = hadethList?.get(position)
        holder.bind(hadeth, position)
    }

    override fun getItemCount(): Int {
        return hadethList?.size ?: 0
    }

    class HadethViewHolder(val binding: ItemHadethBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hadeth: Hadeth?, position: Int) {
            binding.hadethTitle.text = hadeth?.title
            binding.hadethDescription.text = hadeth?.description
        }
    }
}
