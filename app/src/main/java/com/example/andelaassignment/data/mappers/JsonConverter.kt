package com.example.andelaassignment.data.mappers

import com.example.andelaassignment.data.models.ShiftsDataListModel
import com.google.gson.Gson


class JsonConverter(
    private val jsonConverter: Gson
) {
    fun StringToJson(text: String) : ShiftsDataListModel =
        jsonConverter.fromJson(text, ShiftsDataListModel::class.java)
}
