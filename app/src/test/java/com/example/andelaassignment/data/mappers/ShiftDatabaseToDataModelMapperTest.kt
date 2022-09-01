package com.example.andelaassignment.data.mappers

import com.example.andelaassignment.data.models.ShiftDataModel
import com.example.andelaassignment.data.models.ShiftEntityModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class ShiftDatabaseToDataModelMapperTest(
    private val givenInput: ShiftEntityModel,
    private val expectedDataModel: ShiftDataModel
){
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun parameters() = listOf(
            arrayOf(
                ShiftEntityModel(
                    name = "Peter 1",
                    role = "role 1",
                    start_date = "date 1",
                    end_date = "date 1.1",
                    color = "red"
                ),
                ShiftDataModel(
                    name = "Peter 1",
                    role = "role 1",
                    start_date = "date 1",
                    end_date = "date 1.1",
                    color = "red"
                )
            ),
            arrayOf(
                ShiftEntityModel(
                    name = "Peter 2",
                    role = "role 2",
                    start_date = "date 2",
                    end_date = "date 2.1",
                    color = "green"
                ),
                ShiftDataModel(
                    name = "Peter 2",
                    role = "role 2",
                    start_date = "date 2",
                    end_date = "date 2.1",
                    color = "green"
                )
            )
        )
    }

    private lateinit var classUnderTest: ShiftDatabaseToDataModelMapper

    @Before
    fun setUp() {
        classUnderTest = ShiftDatabaseToDataModelMapper()
    }

    @Test
    fun `Given database model When toData Then returns expected Data model`() {
        // When
        val actualDataModel = classUnderTest.toData(givenInput)

        // Then
        assertEquals(expectedDataModel, actualDataModel)
    }
}
