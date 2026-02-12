package com.route.islamic43gsunwed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.route.islamic43gsunwed.R

class TasbeehFragment : Fragment() {

    private lateinit var tvCounter: TextView
    private lateinit var tvZikr: TextView
    private lateinit var imgSebha: ImageView

    private var count = 0
    private var zikrIndex = 0

    private val azkar = arrayOf(
        "سبحان الله",
        "الحمد لله",
        "الله أكبر"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.activity_sebha, container, false)

        tvCounter = view.findViewById(R.id.tvCounter)
        tvZikr = view.findViewById(R.id.tvZikr)
        imgSebha = view.findViewById(R.id.imgSebha)

        imgSebha.setOnClickListener {

            count++
            tvCounter.text = count.toString()

            if (count == 33) {
                count = 0
                zikrIndex++

                if (zikrIndex == azkar.size) {
                    zikrIndex = 0
                }

                tvZikr.text = azkar[zikrIndex]
                tvCounter.text = count.toString()
            }
        }

        return view
    }
}
