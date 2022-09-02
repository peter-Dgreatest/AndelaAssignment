package com.example.andelaassignment.presentation

import com.example.andelaassignment.data.models.ShiftEntityModel
import com.example.andelaassignment.presentation.mapper.ShiftDatabaseToPresentationMapper
import com.example.andelaassignment.presentation.model.ShiftPresentationModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ShiftDomainToPresentationMapperTest(
    private val givenInput: ShiftEntityModel,
    private val expectedDataModel: ShiftPresentationModel
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
                ShiftPresentationModel(
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
                ShiftPresentationModel(
                    name = "Peter 2",
                    role = "role 2",
                    start_date = "date 2",
                    end_date = "date 2.1",
                    color = "green"
                )
            )
        )
    }

    private lateinit var classUnderTest: ShiftDatabaseToPresentationMapper

    @Before
    fun setUp() {
        classUnderTest = ShiftDatabaseToPresentationMapper()
    }

    @Test
    fun `Given domain model When toPresentation Then returns expected Presentation model`() {
        // When
        val actualDataModel = classUnderTest.toPresentation(givenInput)

        // Then
        assertEquals(expectedDataModel, actualDataModel)
    }
}


