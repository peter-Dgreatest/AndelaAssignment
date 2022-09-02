package com.example.andelaassignment.data

import com.example.andelaassignment.data.models.ShiftDataModel
import com.example.andelaassignment.data.models.ShiftsDataListModel
import com.example.andelaassignment.domain.mapper.ShiftDatabaseToDomainMapper
import com.example.andelaassignment.domain.ShiftsRepository
import kotlinx.coroutines.flow.asFlow

class ShiftsDataRepository(
    private val shiftsDataSource: ShiftsDataSource
) : ShiftsRepository {
    override fun shifts() =
        shiftsDataSource.fetch()

    override suspend fun initializeDatabase() {
        shiftsDataSource.unInitialize()
        shiftsDataSource.initialize()
    }

    override suspend fun addShift(shiftDataModel: ShiftDataModel) {
        shiftsDataSource.updateData(ShiftsDataListModel(listOf(shiftDataModel)))
    }
}
