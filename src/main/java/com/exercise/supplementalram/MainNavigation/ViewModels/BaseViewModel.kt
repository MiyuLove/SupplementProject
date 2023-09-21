package com.exercise.supplementalram.MainNavigation.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.exercise.supplementalram.LocalDatabase.Entity.SuppEntity
import com.exercise.supplementalram.LocalDatabase.Repository.SuppRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel(){
    private val repository = SuppRepository()
    private lateinit var suppEntityList : LiveData<List<SuppEntity>>
    val getSuppEntityList : LiveData<List<SuppEntity>>
        get() = suppEntityList

    protected fun readAllData()= viewModelScope.launch (Dispatchers.IO){
        suppEntityList = repository.read().asLiveData()
    }

    fun create(suppEntity: SuppEntity) = viewModelScope.launch (Dispatchers.IO){
        repository.create(suppEntity)
    }

    fun delete(suppEntity: SuppEntity) = viewModelScope.launch (Dispatchers.IO){
        repository.delete(suppEntity)
    }

    fun deleteAllDate() = viewModelScope.launch (Dispatchers.IO){
        repository.deleteAllData()
    }
}