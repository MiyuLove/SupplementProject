package com.exercise.supplementalram.MainNavigation.RecyclerViewAdapters

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exercise.supplementalram.LocalDatabase.Entity.SuppEntity
import com.exercise.supplementalram.MainNavigation.OnMenuCallback
import com.exercise.supplementalram.ViewUtilBox.TextUtil.Companion.textUtil
import com.exercise.supplementalram.databinding.SuppCheckItemBinding

class SuppCheckRecyclerViewAdapter(
    private val suppCheckList : List<SuppEntity>,
    private val onMenuCallback: OnMenuCallback
) : RecyclerView.Adapter<SuppCheckRecyclerViewAdapter.ViewHolder>()
{
    class ViewHolder(binding : SuppCheckItemBinding) : RecyclerView.ViewHolder(binding.root){
        val checkItemName = binding.checkItemSuppName
        val checkItemButton = binding.checkItemButton
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = SuppCheckItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.checkItemName.text = suppCheckList[position].name
        holder.checkItemName.textUtil(
            autoSizeMinTextSize = 15,
            autoSizeMaxTextSize = 30,
            autoSizeStepGranularity = 3,
        )

        holder.checkItemButton.setOnClickListener {
            onMenuCallback.onMenuListDeleted(suppCheckList[position])
        }
    }

    override fun getItemCount(): Int {
        return suppCheckList.size
    }
}