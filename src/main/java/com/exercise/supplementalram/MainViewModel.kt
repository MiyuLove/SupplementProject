package com.exercise.supplementalram

import androidx.lifecycle.ViewModel
import com.exercise.supplementalram.LocalDatabase.Entity.SuppEntity

class MainViewModel : ViewModel(){
    lateinit var usingSuppData : SuppEntity
}