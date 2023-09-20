package com.exercise.supplementalram.MainNavigation.RecyclerViewAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exercise.supplementalram.LocalDatabase.Entity.SuppEntity
import com.exercise.supplementalram.databinding.ListSuppItemBinding
import com.exercise.supplementalram.databinding.SuppCheckItemBinding

class ListSuppRecyclerViewAdapter (
    private val listSupp : List<SuppEntity>,)
    :RecyclerView.Adapter<ListSuppRecyclerViewAdapter.ViewHolder>(){

    class ViewHolder(binding : ListSuppItemBinding) : RecyclerView.ViewHolder(binding.root){
        val listItemName = binding.listSuppItemName
        val listItemButton = binding.listSuppItemButton
        val listItemCycle = binding.listSuppItemCycle
        val listItemAlarm = binding.listSuppItemAlarm
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ListSuppItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.listItemName.text = listSupp[position].name
        holder.listItemButton.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return listSupp.size
    }
}