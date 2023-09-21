package com.exercise.supplementalram.MainNavigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.exercise.supplementalram.MainActivity
import com.exercise.supplementalram.MainViewModel
import com.exercise.supplementalram.R
import com.exercise.supplementalram.databinding.FragmentInfoSuppBinding

class InfoSuppFragment : Fragment() {
    private lateinit var binding :  FragmentInfoSuppBinding
    private lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = (requireActivity() as MainActivity).mainViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentInfoSuppBinding.inflate(inflater,container, false)
        initView()
        return binding.root
    }
    private fun initView(){
        Log.d("info", mainViewModel.usingSuppData.toString())
    }
}