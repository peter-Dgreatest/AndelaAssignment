package com.example.andelaassignment.di

import com.example.andelaassignment.data.mappers.ShiftDatabaseToDataModelMapper
import com.example.andelaassignment.presentation.mapper.ShiftDomainToPresentationMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class PresentationModule {
    @Provides
    fun provideShiftDomainToPresentationMapper() = ShiftDomainToPresentationMapper()

    @Provides
    fun provideShiftDatabaseToDataModelMapper() = ShiftDatabaseToDataModelMapper()

//    @Provides
//    fun providesShiftListViewModel(
//        getShiftsUseCase: GetShiftsUseCase,
//        shiftDomainToPresentationMapper: ShiftDomainToPresentationMapper
//    ) = ShiftListViewModel(
//        getShiftsUseCase = getShiftsUseCase,
//        shiftsDomainToPresentationMapper = shiftDomainToPresentationMapper
//    )
}
