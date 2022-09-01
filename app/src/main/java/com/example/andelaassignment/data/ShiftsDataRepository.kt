package com.example.andelaassignment.data

import com.example.andelaassignment.domain.ShiftDatabaseToDomainMapper
import com.example.andelaassignment.domain.ShiftsRepository

class ShiftsDataRepository(
    private val shiftsDataSource: ShiftsDataSource,
    private val shiftDatabaseToDomainMapper: ShiftDatabaseToDomainMapper
) : ShiftsRepository {
    override suspend fun shifts() = shiftsDataSource.fetch().map {
        shiftDatabaseToDomainMapper.toDomain(it)
    }

    override suspend fun initializeDatabase() {
        shiftsDataSource.unInitialize()
        shiftsDataSource.initialize()
    }
}
