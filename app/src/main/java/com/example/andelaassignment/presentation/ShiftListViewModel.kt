package com.example.andelaassignment.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andelaassignment.domain.usecase.GetShiftsUseCase
import com.example.andelaassignment.domain.usecase.UpdateShiftsUseCase
import com.example.andelaassignment.presentation.mapper.ShiftDomainToPresentationMapper
import com.example.andelaassignment.presentation.model.ShiftPresentationModel
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
    private val shiftsDomainToPresentationMapper: ShiftDomainToPresentationMapper
) : ViewModel() {


    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    var shifts = MutableLiveData<List<ShiftPresentationModel>>()

    init {
        viewModelScope.launch {
            updateShiftsUseCase.initialize()
            shifts.value =
                getShiftsUseCase.executeInBackground().map { shiftsDomainToPresentationMapper.toPresentation(it) }
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
}
