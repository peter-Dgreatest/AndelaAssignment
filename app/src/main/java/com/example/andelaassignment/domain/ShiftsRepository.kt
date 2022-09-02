package com.example.andelaassignment.domain

import androidx.lifecycle.LiveData
import com.example.andelaassignment.data.models.ShiftDataModel
import com.example.andelaassignment.data.models.ShiftEntityModel
import com.example.andelaassignment.domain.model.ShiftDomainModel
import kotlinx.coroutines.flow.Flow

interface ShiftsRepository {
    fun shifts() : LiveData<List<ShiftEntityModel>>
    suspend fun initializeDatabase()
    suspend fun addShift(shiftDataModel: ShiftDataModel)
}
