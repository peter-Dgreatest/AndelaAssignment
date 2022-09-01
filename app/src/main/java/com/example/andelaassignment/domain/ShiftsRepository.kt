package com.example.andelaassignment.domain

import com.example.andelaassignment.domain.model.ShiftDomainModel

interface ShiftsRepository {
    suspend fun shifts() : List<ShiftDomainModel>
    suspend fun initializeDatabase() : Unit
}
