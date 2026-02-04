package com.route.islamic43gsunwed.fragments.quran.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic43gsunwed.databinding.ItemChapterBinding
import com.route.islamic43gsunwed.fragments.quran.model.ChapterDM

// Chapter -> index , englishName , arabicName , versesLength

class ChaptersAdapter(val chapters: List<ChapterDM>? = null) :
    RecyclerView.Adapter<ChaptersAdapter.ChapterViewHolder>() {
    var onChapterClickListener: OnChapterClickListener? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChapterViewHolder {
        // 1 Recycler View Different View Types

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemChapterBinding.inflate(inflater, parent, false)
        return ChapterViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ChapterViewHolder,
        position: Int
    ) {
        val chapterDM = chapters?.get(position)
        holder.binding.root.setOnClickListener {
            if (chapterDM != null)
                onChapterClickListener?.onChapterClick(chapterDM, position)
        }
        holder.bind(chapterDM, position)
    }

    override fun getItemCount(): Int {
//        if (chapters == null)
//            return 0
//        return chapters.size
        return chapters?.size ?: 0
    }


    class ChapterViewHolder(val binding: ItemChapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(chapterDM: ChapterDM?, position: Int) {
            binding.chapterLength.text = "${chapterDM?.length} Verses"
            binding.chapterNameArabic.text = chapterDM?.arabicName
            binding.chapterNameEnglish.text = chapterDM?.englishName
            binding.chapterIndexTextView.text = chapterDM?.index
        }
    }
}