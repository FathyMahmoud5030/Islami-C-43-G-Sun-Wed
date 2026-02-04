package com.route.islamic43gsunwed.chapterDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islamic43gsunwed.chapterDetails.adapter.VersesAdapter
import com.route.islamic43gsunwed.databinding.ActivityChapterDetailsBinding

class ChapterDetailsActivity : AppCompatActivity() {
    private var index: String? = null
    private var englishName: String? = null
    private var arabicName: String? = null
    private lateinit var binding: ActivityChapterDetailsBinding
    private lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.iconBack.setOnClickListener {
            finish()
        }
        initArguments()
        initializeData()
        initializeVersesRecyclerView()
    }

    private fun initVersesList(): List<String> {
        val verses = assets.open("quran/$index.txt").bufferedReader().use {
            it.readLines()
        }
        return verses.filter {
            it.isNotBlank()
        }
    }

    private fun initializeVersesRecyclerView() {

        adapter = VersesAdapter(initVersesList())
        binding.versesRecyclerView.adapter = adapter
    }

    private fun initializeData() {
        binding.chapterNameArabic.text = arabicName
        binding.chapterNameEnglish.text = englishName
    }

    private fun initArguments() {
        englishName = intent.getStringExtra(ChapterDetailsKeys.englishName)
        arabicName = intent.getStringExtra(ChapterDetailsKeys.arabicName)
        index = intent.getStringExtra(ChapterDetailsKeys.index)
    }
}