package com.exercise.supplementalram.LocalDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.exercise.supplementalram.LocalDatabase.Dao.SuppDao
import com.exercise.supplementalram.LocalDatabase.Entity.SuppEntity

@Database(entities = [SuppEntity::class], version = 2)
abstract class SuppDatabase : RoomDatabase(){

    abstract fun suppDao() : SuppDao


    companion object {
        @Volatile
        private var INSTANCE : SuppDatabase? = null
        fun getDatabase(
            context: Context
        ): SuppDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SuppDatabase::class.java,
                    "supp_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}