package com.example.andelaassignment.ui.mappers

import android.graphics.Color.red
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.andelaassignment.R
import com.example.andelaassignment.presentation.model.ShiftPresentationModel
import com.example.andelaassignment.ui.model.ShiftUiModel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class ShiftPresentationToUiModelMapper {
    //
    @RequiresApi(Build.VERSION_CODES.O)
    fun toUi(input: ShiftPresentationModel): ShiftUiModel {


        //2018-04-20 9:00:00
        val dateTimeString = input.start_date.substringBefore( " -")
        val dateTimeStringFormatter = SimpleDateFormat("yyyy-MM-dd H:mm:ss")

        val dateTime: Date = dateTimeStringFormatter.parse(dateTimeString)
        val dateString = input.start_date.substringBefore( " ")
        val date = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE)


        return ShiftUiModel(
            displayText = "${input.name} (${input.role}) ${date.dayOfWeek.toString().substring(0,3).toLowerCase().capitalize()} ${date.monthValue}/${date.dayOfMonth}",
            color = getColorRescource(input.color),
            time = "${dateTime.hours}:${dateTime.minutes}PM"
        )
    }

    private fun getColorRescource(color: String) =
        when(color) {
            "red" -> R.color.red_color
            "blue" -> R.color.blue_color
            "green" -> R.color.green_color
            else -> {
                R.color.black
            }
        }
}
