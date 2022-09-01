package com.example.andelaassignment.data.models

data class ShiftDataModel(
    val role: String,
    val name: String,
    val start_date: String,
    val end_date: String,
    val color: String
)

data class ShiftsDataListModel(
    val shifts: Collection<ShiftDataModel>
)
