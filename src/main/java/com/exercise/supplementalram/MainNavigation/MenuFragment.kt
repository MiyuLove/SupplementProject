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
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.exercise.supplementalram.GlobalApplication
import com.exercise.supplementalram.LocalDatabase.Entity.SuppEntity
import com.exercise.supplementalram.MainNavigation.RecyclerViewAdapters.SuppCheckRecyclerViewAdapter
import com.exercise.supplementalram.MainNavigation.ViewModels.MenuViewModel
import com.exercise.supplementalram.MainViewModel
import com.exercise.supplementalram.R
import com.exercise.supplementalram.ViewUtilBox.TextUtil.Companion.textUtil
import com.exercise.supplementalram.databinding.FragmentMenuBinding

class MenuFragment : Fragment(), OnMenuCallback {
    private lateinit var binding : FragmentMenuBinding
    private lateinit var menuViewModel: MenuViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        menuViewModel = ViewModelProvider(this)[MenuViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        navController = findNavController()

        initView()
        return binding.root
    }

    private fun initView(){
        binding.menuTitleText.textUtil()
        binding.menuNaviButton.setOnClickListener {
            navController.navigate(R.id.action_menuFragment_to_listSuppFragment)
        }

        menuViewModel.getSuppEntityList.observe(viewLifecycleOwner){
            setMenuEmptyImage(it.isEmpty())
            setMenuSuppRecyclerView(it)
        }
    }

    private fun setMenuSuppRecyclerView(list : List<SuppEntity>){
        binding.menuSuppRecyclerView.adapter = SuppCheckRecyclerViewAdapter(list,this)
        binding.menuSuppRecyclerView.layoutManager = LinearLayoutManager(this.context)
    }

    private fun setMenuEmptyImage(empty : Boolean){
        binding.menuEmptyImage.visibility =
            if(empty) View.VISIBLE else View.INVISIBLE
    }

    override fun onMenuListDeleted(suppEntity: SuppEntity) {
        menuViewModel.delete(suppEntity)
    }
}

interface OnMenuCallback{
    fun onMenuListDeleted(suppEntity: SuppEntity)
}