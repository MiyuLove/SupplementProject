package com.exercise.supplementalram.LocalDatabase.Repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.exercise.supplementalram.GlobalApplication
import com.exercise.supplementalram.LocalDatabase.Entity.SuppEntity
import com.exercise.supplementalram.LocalDatabase.SuppDatabase
import kotlinx.coroutines.flow.Flow

class SuppRepository {
    private val context = GlobalApplication.getContext()

    private val db = SuppDatabase.getDatabase(context)

    fun create(suppEntity: SuppEntity) = db.suppDao().create(suppEntity)

    fun read() = db.suppDao().read()

    fun update(suppEntity: SuppEntity) = db.suppDao().update(suppEntity)

    fun delete(suppEntity: SuppEntity) = db.suppDao().delete(suppEntity)

    fun deleteAllData() = db.suppDao().deleteAllData()
}