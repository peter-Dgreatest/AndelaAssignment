package com.example.andelaassignment.data.mappers

import com.example.andelaassignment.data.models.ShiftDataModel
import com.example.andelaassignment.data.models.ShiftEntityModel

class ShiftDataToDatabaseModelMapper {
    fun toDatabase(input : ShiftDataModel) =
        ShiftEntityModel(
            role = input.role,
            name = input.name,
            color = input.color,
            start_date = input.start_date,
            end_date = input.end_date
        )
}
