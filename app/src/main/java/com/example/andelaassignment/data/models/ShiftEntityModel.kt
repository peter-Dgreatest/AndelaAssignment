package com.example.andelaassignment.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shifts")
data class ShiftEntityModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val role: String,
    val name: String,
    val start_date: String,
    val end_date: String,
    val color: String
)
