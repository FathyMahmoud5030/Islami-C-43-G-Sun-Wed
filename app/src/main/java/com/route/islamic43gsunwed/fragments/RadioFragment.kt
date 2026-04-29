package com.route.islamic43gsunwed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.route.islamic43gsunwed.api.ApiManager
import com.route.islamic43gsunwed.databinding.FragmentRadioBinding
import com.route.islamic43gsunwed.fragments.quran.adapter.RadioAdapter
import com.route.islamic43gsunwed.fragments.quran.model.RadioResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RadioFragment : Fragment() {

    private var _binding: FragmentRadioBinding? = null
    private val binding get() = _binding!!
    private val radioAdapter = RadioAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRadioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.radioRecyclerView.adapter = radioAdapter
        getRadios()
    }

    private fun getRadios() {
        ApiManager.getWebServices().getRadios().enqueue(object : Callback<RadioResponse> {
            override fun onResponse(call: Call<RadioResponse>, response: Response<RadioResponse>) {
                if (response.isSuccessful) {
                    radioAdapter.bindData(response.body()?.radios)
                }
            }
            override fun onFailure(call: Call<RadioResponse>, t: Throwable) {
                Toast.makeText(context, "Error: ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}