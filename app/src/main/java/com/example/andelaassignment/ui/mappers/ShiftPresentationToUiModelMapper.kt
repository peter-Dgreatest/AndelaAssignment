package com.example.andelaassignment.ui.mappers

import com.example.andelaassignment.presentation.model.ShiftPresentationModel
import com.example.andelaassignment.ui.ShiftUiModel

class ShiftPresentationToUiModelMapper {
    fun toUi(input: ShiftPresentationModel) = ShiftUiModel(
        role = input.role,
        name = input.name,
        color = input.color,
        start_date = input.start_date,
        end_date = input.end_date
    )
}
