package com.example.andelaassignment.data

import androidx.lifecycle.LiveData
import com.example.andelaassignment.data.local.ShiftDao
import com.example.andelaassignment.data.mappers.JsonConverter
import com.example.andelaassignment.data.mappers.ShiftDataToDatabaseModelMapper
import com.example.andelaassignment.data.models.ShiftEntityModel
import com.example.andelaassignment.data.models.ShiftsDataListModel

interface ShiftsSource {
    fun initialize()

    fun fetch() : LiveData<List<ShiftEntityModel>>

    fun unInitialize()

    fun updateData(shifts: ShiftsDataListModel)
}

class ShiftsDataSource(
    private val jsonConverter : JsonConverter,
    private val shiftDataToDatabaseModelMapper: ShiftDataToDatabaseModelMapper,
    private val shiftsDao: ShiftDao
): ShiftsSource {
    override fun initialize() =
        updateData(jsonConverter.StringToJson(SHIFTSDATA))

    override fun fetch() =
        shiftsDao.getAll()

    override fun unInitialize() =
        shiftsDao.deleteAll()

    override fun updateData(shifts: ShiftsDataListModel) {
        shifts.shifts.map {
            shiftDataToDatabaseModelMapper.toDatabase(it)
        }.forEach {
            shiftsDao.insertAll(it)
        }
    }
}

const val SHIFTSDATA = "{\n" +
        "        \"shifts\": [\n" +
        "         { \n" +
        "                \"role\": \"Waiter\",\n" +
        "                \"name\": \"Anna\",\n" +
        "                \"start_date\": \"2018-04-20 9:00:00 -08:00\",\n" +
        "                \"end_date\": \"2018-4-20 12:00:00 -08:00\",\n" +
        "                \"color\": \"red\"\n" +
        "         },\n" +
        "         { \n" +
        "                \"role\": \"Prep\",\n" +
        "                \"name\": \"Anton\",\n" +
        "                \"start_date\": \"2018-04-20 9:00:00 -08:00\",\n" +
        "                \"end_date\": \"2018-4-20 12:00:00 -08:00\",\n" +
        "                \"color\": \"blue\"\n" +
        "         },\n" +
        "         { \n" +
        "                \"role\": \"Front of House\",\n" +
        "                \"name\": \"Eugene\",\n" +
        "                \"start_date\": \"2018-04-20 12:00:00 -08:00\",\n" +
        "                \"end_date\": \"2018-4-20 22:00:00 -08:00\",\n" +
        "                \"color\": \"red\"\n" +
        "         },\n" +
        "         { \n" +
        "                \"role\": \"Cook\",\n" +
        "                \"name\": \"Keyvan\",\n" +
        "                \"start_date\": \"2018-04-21 7:00:00 -08:00\",\n" +
        "                \"end_date\": \"2018-4-21 12:00:00 -08:00\",\n" +
        "                \"color\": \"green\"\n" +
        "         },        \n" +
        "          { \n" +
        "                \"role\": \"Waiter\",\n" +
        "                \"name\": \"Anna\",\n" +
        "                \"start_date\": \"2018-04-21 9:00:00 -08:00\",\n" +
        "                \"end_date\": \"2018-4-21 14:00:00 -08:00\",\n" +
        "                \"color\": \"red\"\n" +
        "         },\n" +
        "          { \n" +
        "                \"role\": \"Prep\",\n" +
        "                \"name\": \"Anton\",\n" +
        "                \"start_date\": \"2018-04-21 7:00:00 -08:00\",\n" +
        "                \"end_date\": \"2018-4-21 12:00:00 -08:00\",\n" +
        "                \"color\": \"blue\"\n" +
        "         },\n" +
        "         { \n" +
        "                \"role\":\"Front of House\",\n" +
        "                \"name\": \"Eugene\",\n" +
        "                \"start_date\": \"2018-04-21 12:00:00 -08:00\",\n" +
        "                \"end_date\": \"2018-4-21 22:00:00 -08:00\",\n" +
        "                \"color\": \"red\"\n" +
        "         },        \n" +
        "         { \n" +
        "                \"role\":\"Cook\",\n" +
        "                \"name\": \"Keyvan\",\n" +
        "                \"start_date\": \"2018-04-22 7:00:00 -08:00\",\n" +
        "                \"end_date\": \"2018-4-22 12:00:00 -08:00\",\n" +
        "                \"color\": \"green\"\n" +
        "         },\n" +
        "         { \n" +
        "                \"role\": \"Waiter\",\n" +
        "                \"name\": \"Anna\",\n" +
        "                \"start_date\": \"2018-04-22 9:00:00 -08:00\",\n" +
        "                \"end_date\": \"2018-4-22 14:00:00 -08:00\",\n" +
        "                \"color\": \"red\"\n" +
        "         },        \n" +
        "          { \n" +
        "                \"role\":\"Prep\",\n" +
        "                \"name\": \"Anton\",\n" +
        "                \"start_date\": \"2018-04-22 7:00:00 -08:00\",\n" +
        "                \"end_date\": \"2018-4-22 12:00:00 -08:00\",\n" +
        "                \"color\": \"blue\"\n" +
        "         },\n" +
        "         { \n" +
        "                \"role\": \"Front of House\",\n" +
        "                \"name\": \"Eugene\",\n" +
        "                \"start_date\": \"2018-04-22 12:00:00 -08:00\",\n" +
        "                \"end_date\": \"2018-4-22 22:00:00 -08:00\",\n" +
        "                \"color\": \"red\"\n" +
        "         }        \n" +
        "        ]\n" +
        "}"
