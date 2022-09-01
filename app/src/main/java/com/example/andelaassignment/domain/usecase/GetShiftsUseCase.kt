package com.example.andelaassignment.domain.usecase

import com.example.andelaassignment.domain.ShiftsRepository
import com.example.andelaassignment.domain.model.ShiftDomainModel

interface GetShiftsUseCase {
    suspend fun executeInBackground(): List<ShiftDomainModel>
}

class GetShiftsUseCaseImpl(
    private val shiftsRepository: ShiftsRepository
) : GetShiftsUseCase {
    override suspend fun executeInBackground() =
        shiftsRepository.shifts()

}
