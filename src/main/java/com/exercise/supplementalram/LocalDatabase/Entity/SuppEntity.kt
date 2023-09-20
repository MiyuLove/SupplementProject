package com.exercise.supplementalram.LocalDatabase.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "supp_table")
data class SuppEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int,
    @ColumnInfo(name = "nickname")
    val name : String,

    @ColumnInfo(name = "quantity")
    var quantity : Int,
    var remainder : Int,

    @ColumnInfo(name = "date")
    val date : String,

    @ColumnInfo(name = "date_time")
    val date_time : String,

    @ColumnInfo(name = "eaten")
    var eaten : Boolean,

    @ColumnInfo(name = "resource_id")
    val resourceID : String,
)
