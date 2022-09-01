package com.example.andelaassignment.di

import android.content.Context
import com.example.andelaassignment.data.mappers.JsonConverter
import com.example.andelaassignment.data.ShiftsDataSource
import com.example.andelaassignment.data.local.AppDatabase
import com.example.andelaassignment.data.local.ShiftDao
import com.example.andelaassignment.data.mappers.ShiftDataToDatabaseModelMapper
import com.example.andelaassignment.data.mappers.ShiftDatabaseToDataModelMapper
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    private val gson = Gson()

    @Provides
    fun providesJsonConverter() = JsonConverter(gson)

    @Provides
    fun provideShiftDao(@ApplicationContext context: Context) =
        AppDatabase.getInstance(context).shiftsDao

    @Provides
    fun provideShiftDataToDatabaseModelMapper() = ShiftDataToDatabaseModelMapper()

    @Provides
    fun provideShiftDatabaseToDataModelMapper() = ShiftDatabaseToDataModelMapper()

    @Provides
    fun providesShiftsDataSource(
        jsonConverter: JsonConverter,
        shiftDao: ShiftDao,
        shiftDataToDatabaseModelMapper: ShiftDataToDatabaseModelMapper,
        shiftDatabaseToDataModelMapper: ShiftDatabaseToDataModelMapper
    ) = ShiftsDataSource(
        jsonConverter = jsonConverter,
        shiftsDao = shiftDao,
        shiftDataToDatabaseModelMapper = shiftDataToDatabaseModelMapper
    )
}
