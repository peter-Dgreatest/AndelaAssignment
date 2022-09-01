package com.example.andelaassignment.di

import com.example.andelaassignment.ui.mappers.ShiftPresentationToUiModelMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class UiModule {
    @Provides
    fun provideShiftPresentationToUiModelMapper() = ShiftPresentationToUiModelMapper()
}
