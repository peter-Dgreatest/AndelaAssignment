package com.example.andelaassignment.data.mappers

import com.example.andelaassignment.data.models.ShiftDataModel
import com.example.andelaassignment.data.models.ShiftsDataListModel
import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class JsonConverterTest{
    private lateinit var classUnderTest: JsonConverter

    val expectedResult = ShiftsDataListModel(
        listOf(
            ShiftDataModel(
                name = "Peter 1",
                role = "role 1",
                start_date = "date 1",
                end_date = "date 1.1",
                color = "red"
            ),
            ShiftDataModel(
                name = "Peter 2",
                role = "role 2",
                start_date = "date 2",
                end_date = "date 2.1",
                color = "green"
            ),
            ShiftDataModel(
                name = "James 3",
                role = "rrr 3",
                start_date = "ddd 3",
                end_date = "dfg 3.1",
                color = "orange"
            )
        )
    )
    @Before
    fun setUp() {
        classUnderTest = JsonConverter(
            Gson()
        )
    }

    @Test
    fun `Given json String When toData Then returns expected Data model`() {
        // When
        val actualResult = classUnderTest.StringToJson(
            "{\n" +
                    "        \"shifts\": [\n" +
                    "         { \n" +
                    "                \"role\": \"role 1\",\n" +
                    "                \"name\": \"Peter 1\",\n" +
                    "                \"start_date\": \"date 1\",\n" +
                    "                \"end_date\": \"date 1.1\",\n" +
                    "                \"color\": \"red\"\n" +
                    "         },\n" +
                    "         { \n" +
                    "                \"role\": \"role 2\",\n" +
                    "                \"name\": \"Peter 2\",\n" +
                    "                \"start_date\": \"date 2\",\n" +
                    "                \"end_date\": \"date 2.1\",\n" +
                    "                \"color\": \"green\"\n" +
                    "         },\n" +
                    "         { \n" +
                    "                \"role\": \"rrr 3\",\n" +
                    "                \"name\": \"James 3\",\n" +
                    "                \"start_date\": \"ddd 3\",\n" +
                    "                \"end_date\": \"dfg 3.1\",\n" +
                    "                \"color\": \"orange\"\n" +
                    "         }" +
                    "        ]\n" +
                    "}"
        )

        // Then
        assertEquals(expectedResult, actualResult)
    }
}
