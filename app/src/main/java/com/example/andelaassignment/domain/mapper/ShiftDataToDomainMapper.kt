package com.example.andelaassignment.domain

import com.example.andelaassignment.data.models.ShiftEntityModel
import com.example.andelaassignment.domain.model.ShiftDomainModel

class ShiftDatabaseToDomainMapper {
    fun toDomain(input: ShiftEntityModel) = ShiftDomainModel(
        role = input.role,
        name = input.name,
        color = input.color,
        start_date = input.start_date,
        end_date = input.end_date
    )
}
