package com.route.islamic43gsunwed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic43gsunwed.databinding.FragmentHadethBinding
import com.route.islamic43gsunwed.databinding.FragmentQuranBinding
import com.route.islamic43gsunwed.databinding.FragmentRadioBinding
import com.route.islamic43gsunwed.databinding.FragmentTasbeehBinding

class RadioFragment : Fragment() {
    private lateinit var binding: FragmentRadioBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRadioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}