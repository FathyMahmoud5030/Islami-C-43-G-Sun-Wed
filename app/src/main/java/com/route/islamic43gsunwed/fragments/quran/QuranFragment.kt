package com.route.islamic43gsunwed.fragments.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic43gsunwed.chapterDetails.ChapterDetailsActivity
import com.route.islamic43gsunwed.chapterDetails.ChapterDetailsKeys
import com.route.islamic43gsunwed.databinding.FragmentQuranBinding
import com.route.islamic43gsunwed.fragments.quran.adapter.ChaptersAdapter
import com.route.islamic43gsunwed.fragments.quran.adapter.OnChapterClickListener
import com.route.islamic43gsunwed.fragments.quran.model.ChapterDM

class QuranFragment : Fragment() {
    private lateinit var binding: FragmentQuranBinding
    private lateinit var adapter: ChaptersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initChaptersRecyclerView()
    }

    private fun initChaptersRecyclerView() {
        adapter = ChaptersAdapter(ChapterDM.getChaptersList())
        adapter.onChapterClickListener = object : OnChapterClickListener {
            override fun onChapterClick(
                chapterDM: ChapterDM,
                position: Int
            ) {
                if (context != null) {
                    val intent = Intent(context, ChapterDetailsActivity::class.java)
                    intent.putExtra(ChapterDetailsKeys.englishName, chapterDM.englishName)
                    intent.putExtra(ChapterDetailsKeys.arabicName, chapterDM.arabicName)
                    intent.putExtra(ChapterDetailsKeys.index, chapterDM.index)
                    startActivity(intent)
                }
            }

        }
        binding.surasRecyclerView.adapter = adapter

    }
    //   ScrollView /      Nested Scroll View
    //   Scrollable component   -- > RecyclerView

}