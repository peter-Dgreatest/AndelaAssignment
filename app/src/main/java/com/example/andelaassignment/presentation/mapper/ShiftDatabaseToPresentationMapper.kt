package com.example.andelaassignment.presentation.mapper

import com.example.andelaassignment.data.models.ShiftEntityModel
import com.example.andelaassignment.domain.model.ShiftDomainModel
import com.example.andelaassignment.presentation.model.ShiftPresentationModel

class ShiftDatabaseToPresentationMapper {
    fun toPresentation(input: ShiftEntityModel) = ShiftPresentationModel(
        role = input.role,
        name = input.name,
        color = input.color,
        start_date = input.start_date,
        end_date = input.end_date
    )
}
