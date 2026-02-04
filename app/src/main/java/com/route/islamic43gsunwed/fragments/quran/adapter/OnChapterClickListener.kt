package com.route.islamic43gsunwed.fragments.quran.adapter

import com.route.islamic43gsunwed.fragments.quran.model.ChapterDM

interface OnChapterClickListener {
    fun onChapterClick(chapterDM: ChapterDM, position: Int)
}