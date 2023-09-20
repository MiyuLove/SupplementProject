package com.exercise.supplementalram

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance

class GlobalApplication : Application() {
    init{
        instance = this
    }
    companion object{
        private var instance : GlobalApplication? = null

        fun getContext() : Context {
            return instance!!.applicationContext
        }
    }
}