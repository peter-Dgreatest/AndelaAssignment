package com.example.andelaassignment.data

import com.example.andelaassignment.data.models.ShiftEntityModel
import com.example.andelaassignment.domain.ShiftDatabaseToDomainMapper
import com.example.andelaassignment.domain.model.ShiftDomainModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

private val expectedDomainModel = listOf(
    ShiftDomainModel(
        name = "Peter 1",
        role = "role 1",
        start_date = "date 1",
        end_date = "date 1.1",
        color = "red"
    ),
    ShiftDomainModel(
        name = "Peter 2",
        role = "role 2",
        start_date = "date 2",
        end_date = "date 2.1",
        color = "green"
    ),
    ShiftDomainModel(
        name = "Peter 3",
        role = "role 3",
        start_date = "date 3",
        end_date = "date 3.1",
        color = "blue"
    )
)

private val givenDataModel = listOf(
    ShiftEntityModel(
        name = "Peter 1",
        role = "role 1",
        start_date = "date 1",
        end_date = "date 1.1",
        color = "red"
    ),
    ShiftEntityModel(
        name = "Peter 2",
        role = "role 2",
        start_date = "date 2",
        end_date = "date 2.1",
        color = "green"
    ),
    ShiftEntityModel(
        name = "Peter 3",
        role = "role 3",
        start_date = "date 3",
        end_date = "date 3.1",
        color = "blue"
    )
)

@RunWith(MockitoJUnitRunner::class)
class ShiftsDataRepositoryTest {

    private lateinit var classUnderTest: ShiftsDataRepository

    @Mock
    lateinit var shiftsDataSource: ShiftsDataSource

    @Mock
    lateinit var shiftDatabaseToDomainMapper: ShiftDatabaseToDomainMapper

    @Before
    fun setup() {
        classUnderTest = ShiftsDataRepository(
            shiftsDataSource,
            shiftDatabaseToDomainMapper
        )
    }

    @Test
    fun `When fetch() Then returns shifts`() = runBlocking {

        // Given
        given(shiftsDataSource.fetch()).willReturn(
            givenDataModel
        )

        givenDataModel.forEachIndexed{index, element ->
            given(shiftDatabaseToDomainMapper.toDomain(element))
                .willReturn(expectedDomainModel[index])
    }

        // When
        var actualResult: List<ShiftDomainModel>? = classUnderTest.shifts()

        // Then
        assertEquals(expectedDomainModel, actualResult)
    }
}

