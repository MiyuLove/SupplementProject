package com.exercise.supplementalram.MainNavigation.ViewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.viewModelScope
import com.exercise.supplementalram.GlobalApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel : BaseViewModel() {
    init{
        readAllData()
    }
}