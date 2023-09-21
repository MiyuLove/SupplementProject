package com.exercise.supplementalram.MainNavigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.exercise.supplementalram.LocalDatabase.Entity.SuppEntity
import com.exercise.supplementalram.MainActivity
import com.exercise.supplementalram.MainNavigation.RecyclerViewAdapters.ListSuppRecyclerViewAdapter
import com.exercise.supplementalram.MainNavigation.ViewModels.ListViewModel
import com.exercise.supplementalram.MainViewModel
import com.exercise.supplementalram.R
import com.exercise.supplementalram.ViewUtilBox.TextUtil.Companion.textUtil
import com.exercise.supplementalram.databinding.FragmentListSuppBinding
import com.exercise.supplementalram.databinding.ListSuppItemBinding

class ListSuppFragment : Fragment(), OnListCallback {
    private lateinit var binding : FragmentListSuppBinding
    private lateinit var listViewModel : ListViewModel
    private lateinit var mainViewModel : MainViewModel
    private lateinit var navController: NavController

    private var dd = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        mainViewModel = (requireActivity() as MainActivity).mainViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentListSuppBinding.inflate(inflater,container,false)
        navController = findNavController()
        initView()
        return binding.root
    }

    private fun initView(){
        binding.listSuppTitleText.textUtil()
        binding.listSuppButton.setOnClickListener {
            dd ++
            listViewModel.create(SuppEntity(0,dd.toString(),3,3,"","",false,""))
        }

        listViewModel.getSuppEntityList.observe(viewLifecycleOwner){
            binding.listSuppRecyclerView.layoutManager = LinearLayoutManager(context)
            binding.listSuppRecyclerView.adapter = ListSuppRecyclerViewAdapter(it, this)
        }
    }

    override fun onListClicked(suppEntity: SuppEntity) {
        mainViewModel.usingSuppData = suppEntity
        navController.navigate(R.id.action_listSuppFragment_to_infoSuppFragment)
    }
}

interface OnListCallback{
    fun onListClicked(suppEntity: SuppEntity)
}