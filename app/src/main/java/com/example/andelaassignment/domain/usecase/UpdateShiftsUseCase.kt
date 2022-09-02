package com.example.andelaassignment.domain.usecase

import com.example.andelaassignment.domain.mapper.ShiftDomainToDataMapper
import com.example.andelaassignment.domain.ShiftsRepository
import com.example.andelaassignment.domain.model.ShiftDomainModel

interface UpdateShiftsUseCase {
    suspend fun initialize(): Unit
    suspend fun insert(shiftDomainModel: ShiftDomainModel): Unit
}

class UpdateShiftsUseCaseImpl(
    private val shiftsRepository: ShiftsRepository,
    private val shiftDomainToDataMapper: ShiftDomainToDataMapper
) : UpdateShiftsUseCase {
    override suspend fun initialize() {
        shiftsRepository.initializeDatabase()
    }

    override suspend fun insert(shiftDomainModel: ShiftDomainModel) {
        shiftsRepository.addShift(shiftDomainToDataMapper.toData(shiftDomainModel))
    }

}
