package com.example.andelaassignment

import android.app.Application
import com.example.andelaassignment.data.ShiftsDataSource
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {
    @Inject
    lateinit var shiftsDataSource: ShiftsDataSource
    override fun onTerminate() {
        shiftsDataSource.unInitialize()
        super.onTerminate()
    }
}
