package com.example.andelaassignment.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.andelaassignment.domain.usecase.GetShiftsUseCase
import com.example.andelaassignment.domain.usecase.UpdateShiftsUseCase
import com.example.andelaassignment.presentation.mapper.ShiftDatabaseToPresentationMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShiftListViewModel @Inject constructor(
    private val getShiftsUseCase: GetShiftsUseCase,
    private val updateShiftsUseCase: UpdateShiftsUseCase,
    private val shiftsDatabaseToPresentationMapper: ShiftDatabaseToPresentationMapper
) : ViewModel() {


    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    //cached
    private val _shifts = getShiftsUseCase.executeInBackground()

    //public
    val shifts = Transformations.map(_shifts){
        _shifts.value?.map { shiftsDatabaseToPresentationMapper.toPresentation(it) }
    }

    init {
        viewModelScope.launch {
            updateShiftsUseCase.initialize()
        }
    }

    val navigateToNextActivity = MutableLiveData<Boolean>()

    fun onNavigate(){
        navigateToNextActivity.value=true
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun endNavigation() {
        navigateToNextActivity.value=false
    }
}
