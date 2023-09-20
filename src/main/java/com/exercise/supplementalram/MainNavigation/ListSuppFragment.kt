package com.exercise.supplementalram.MainNavigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.exercise.supplementalram.LocalDatabase.Entity.SuppEntity
import com.exercise.supplementalram.MainNavigation.RecyclerViewAdapters.ListSuppRecyclerViewAdapter
import com.exercise.supplementalram.MainNavigation.ViewModels.ListViewModel
import com.exercise.supplementalram.R
import com.exercise.supplementalram.databinding.FragmentListSuppBinding
import com.exercise.supplementalram.databinding.ListSuppItemBinding

class ListSuppFragment : Fragment(), OnListCallback {
    private lateinit var binding : FragmentListSuppBinding
    private lateinit var listViewModel : ListViewModel
    private var dd = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentListSuppBinding.inflate(inflater,container,false)
        initView()
        return binding.root
    }

    private fun initView(){
        Log.d("dd", dd.toString())
        binding.listSuppButton.setOnClickListener {
            dd ++
            listViewModel.create(SuppEntity(0,dd.toString(),3,3,"","",false,""))
        }

        listViewModel.getSuppEntityList.observe(viewLifecycleOwner){
            binding.listSuppRecyclerView.layoutManager = LinearLayoutManager(context)
            binding.listSuppRecyclerView.adapter = ListSuppRecyclerViewAdapter(it)
        }
    }

    override fun onListClicked(suppEntity: SuppEntity) {
        TODO("이거 호출하는 suppEntity를 mainViewModel에 옮겨. 성공적으로 옮기면 그 다음 navigation,,,")
    }
}

interface OnListCallback{
    fun onListClicked(suppEntity: SuppEntity)
}