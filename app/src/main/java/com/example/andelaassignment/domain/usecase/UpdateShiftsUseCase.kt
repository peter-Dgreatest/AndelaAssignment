package com.example.andelaassignment.domain.usecase

import com.example.andelaassignment.domain.ShiftsRepository
import com.example.andelaassignment.domain.model.ShiftDomainModel

interface UpdateShiftsUseCase {
    suspend fun initialize(): Unit
    suspend fun insert(shiftDomainModel: ShiftDomainModel): Unit
}

class UpdateShiftsUseCaseImpl(
    private val shiftsRepository: ShiftsRepository
) : UpdateShiftsUseCase {
    override suspend fun initialize() {
        shiftsRepository.initializeDatabase()
    }

    override suspend fun insert(shiftDomainModel: ShiftDomainModel) {
        TODO("Not yet implemented")
    }

}
