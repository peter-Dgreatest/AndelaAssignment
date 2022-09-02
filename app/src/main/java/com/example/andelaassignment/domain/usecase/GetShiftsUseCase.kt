package com.example.andelaassignment.domain.usecase

import androidx.lifecycle.LiveData
import com.example.andelaassignment.data.models.ShiftEntityModel
import com.example.andelaassignment.domain.ShiftsRepository

interface GetShiftsUseCase {
    fun executeInBackground(): LiveData<List<ShiftEntityModel>>
}

class GetShiftsUseCaseImpl(
    private val shiftsRepository: ShiftsRepository
) : GetShiftsUseCase {
    override fun executeInBackground() =
        shiftsRepository.shifts()

}
