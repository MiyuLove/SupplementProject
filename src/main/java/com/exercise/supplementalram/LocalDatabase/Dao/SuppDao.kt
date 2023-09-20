package com.exercise.supplementalram.LocalDatabase.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.exercise.supplementalram.LocalDatabase.Entity.SuppEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SuppDao {
    @Query("SELECT * FROM supp_table")
    fun read() : Flow<List<SuppEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun create(supp : SuppEntity)

    @Update
    fun update(supp: SuppEntity)

    @Delete
    fun delete(supp: SuppEntity)

    @Query("DELETE FROM supp_table")
    fun deleteAllData()
}