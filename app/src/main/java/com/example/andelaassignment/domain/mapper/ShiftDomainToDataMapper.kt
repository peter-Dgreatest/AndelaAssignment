package com.example.andelaassignment.domain.mapper

import com.example.andelaassignment.data.models.ShiftDataModel
import com.example.andelaassignment.data.models.ShiftEntityModel
import com.example.andelaassignment.domain.model.ShiftDomainModel

class ShiftDomainToDataMapper {
    fun toData(input: ShiftDomainModel) = ShiftDataModel(
        role = input.role,
        name = input.name,
        color = input.color,
        start_date = input.start_date,
        end_date = input.end_date
    )
}
