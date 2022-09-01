package com.example.andelaassignment.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.andelaassignment.data.models.ShiftsDataListModel
import com.example.andelaassignment.data.models.ShiftEntityModel

@Dao
interface ShiftDao {
    @Query("SELECT * FROM shifts")
    fun getAll(): List<ShiftEntityModel>

    @Insert
    fun insertAll(vararg shifts: ShiftEntityModel)

    @Query("Delete  FROM shifts")
    fun deleteAll()
}
