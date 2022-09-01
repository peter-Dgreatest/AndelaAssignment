package com.example.andelaassignment.data.mappers

import com.example.andelaassignment.data.models.ShiftDataModel
import com.example.andelaassignment.data.models.ShiftEntityModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class ShiftDataToDatabaseModelMapperTest(
    private val givenInput: ShiftDataModel,
    private val expectedDataModel: ShiftEntityModel
){
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun parameters() = listOf(
            arrayOf(
                ShiftDataModel(
                    name = "Peter 1",
                    role = "role 1",
                    start_date = "date 1",
                    end_date = "date 1.1",
                    color = "red"
                ),
                ShiftEntityModel(
                    name = "Peter 1",
                    role = "role 1",
                    start_date = "date 1",
                    end_date = "date 1.1",
                    color = "red"
                )
            ),
            arrayOf(
                ShiftDataModel(
                    name = "Peter 2",
                    role = "role 2",
                    start_date = "date 2",
                    end_date = "date 2.1",
                    color = "green"
                ),
                ShiftEntityModel(
                    name = "Peter 2",
                    role = "role 2",
                    start_date = "date 2",
                    end_date = "date 2.1",
                    color = "green"
                )
            )
        )
    }

    private lateinit var classUnderTest: ShiftDataToDatabaseModelMapper

    @Before
    fun setUp() {
        classUnderTest = ShiftDataToDatabaseModelMapper()
    }

    @Test
    fun `Given database model When toData Then returns expected Data model`() {
        // When
        val actualDataModel = classUnderTest.toDatabase(givenInput)

        // Then
        assertEquals(expectedDataModel, actualDataModel)
    }
}
