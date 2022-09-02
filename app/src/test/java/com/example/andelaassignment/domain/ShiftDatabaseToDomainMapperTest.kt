package com.example.andelaassignment.domain

import com.example.andelaassignment.data.models.ShiftEntityModel
import com.example.andelaassignment.domain.mapper.ShiftDatabaseToDomainMapper
import com.example.andelaassignment.domain.model.ShiftDomainModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ShiftDatabaseToDomainMapperTest(
    private val givenInput: ShiftEntityModel,
    private val expectedDataModel: ShiftDomainModel
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
                ShiftDomainModel(
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
                ShiftDomainModel(
                    name = "Peter 2",
                    role = "role 2",
                    start_date = "date 2",
                    end_date = "date 2.1",
                    color = "green"
                )
            )
        )
    }

    private lateinit var classUnderTest: ShiftDatabaseToDomainMapper

    @Before
    fun setUp() {
        classUnderTest = ShiftDatabaseToDomainMapper()
    }

    @Test
    fun `Given database model When toDomain Then returns expected Domain model`() {
        // When
        val actualDataModel = classUnderTest.toDomain(givenInput)

        // Then
        assertEquals(expectedDataModel, actualDataModel)
    }
}

