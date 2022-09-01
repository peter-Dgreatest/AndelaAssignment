package com.example.andelaassignment.di

import com.example.andelaassignment.data.ShiftsDataRepository
import com.example.andelaassignment.data.ShiftsDataSource
import com.example.andelaassignment.domain.usecase.GetShiftsUseCase
import com.example.andelaassignment.domain.usecase.GetShiftsUseCaseImpl
import com.example.andelaassignment.domain.ShiftDatabaseToDomainMapper
import com.example.andelaassignment.domain.ShiftsRepository
import com.example.andelaassignment.domain.usecase.UpdateShiftsUseCase
import com.example.andelaassignment.domain.usecase.UpdateShiftsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideShiftDatabaseToDomainMapper() = ShiftDatabaseToDomainMapper()

    @Provides
    fun provideShiftsDataRepository(
        shiftsDataSource: ShiftsDataSource,
        shiftsDatabaseToDomainMapper: ShiftDatabaseToDomainMapper
    ) : ShiftsRepository = ShiftsDataRepository(
        shiftsDataSource = shiftsDataSource,
        shiftsDatabaseToDomainMapper
    )

    @Provides
    fun provideGetShiftsUseCase(
        shiftsRepository: ShiftsRepository
    ) : GetShiftsUseCase = GetShiftsUseCaseImpl(
        shiftsRepository = shiftsRepository
    )

    @Provides
    fun provideUpdateShiftsUseCase(
        shiftsRepository: ShiftsRepository
    ) : UpdateShiftsUseCase = UpdateShiftsUseCaseImpl(
        shiftsRepository = shiftsRepository
    )
}
