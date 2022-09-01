package com.example.andelaassignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andelaassignment.R
import com.example.andelaassignment.data.ShiftsDataSource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ShiftListFragment.newInstance())
                .commitNow()
        }
    }
}
