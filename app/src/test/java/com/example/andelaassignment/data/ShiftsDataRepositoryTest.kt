package com.example.andelaassignment.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import com.example.andelaassignment.data.models.ShiftEntityModel
import com.example.andelaassignment.domain.mapper.ShiftDatabaseToDomainMapper
import com.example.andelaassignment.domain.model.ShiftDomainModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.times
import org.mockito.BDDMockito.verify
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ShiftsDataRepositoryTest {

    private lateinit var classUnderTest: ShiftsDataRepository

    @Mock
    lateinit var shiftsDataSource: ShiftsDataSource

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        classUnderTest = ShiftsDataRepository(
            shiftsDataSource
        )
    }

    @Test
    fun `When fetch() Then call dataSource shifts`()  {
        classUnderTest.shifts()
        Mockito.verify(shiftsDataSource, times(1)).fetch()
    }
}

