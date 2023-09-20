package com.exercise.supplementalram.MainNavigation.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.exercise.supplementalram.GlobalApplication
import com.exercise.supplementalram.LocalDatabase.Entity.SuppEntity
import com.exercise.supplementalram.LocalDatabase.Repository.SuppRepository
import com.exercise.supplementalram.LocalDatabase.SuppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MenuViewModel : BaseViewModel() {
    init{
        getAllData()
    }
}