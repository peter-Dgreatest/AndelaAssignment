package com.example.andelaassignment.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andelaassignment.domain.model.ShiftDomainModel
import com.example.andelaassignment.domain.usecase.UpdateShiftsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddShiftViewModel @Inject constructor(
    private val updateShiftsUseCase: UpdateShiftsUseCase
) : ViewModel() {

    private val viewModelJob = SupervisorJob()

    val names: ArrayList<String> = arrayListOf("Anna","Anton","Eugene","Keyvan")
    val colors: ArrayList<String> = arrayListOf("red","green","blue")
    val roles: ArrayList<String> = arrayListOf("Cook","Front of House","Prep","Waiter")


    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    fun addShift(role: String, name: String, startDate: String, endDate: String, color: String){
        viewModelScope.launch {
            updateShiftsUseCase.insert(
                ShiftDomainModel(
                    role = role,
                    name = name,
                    start_date = startDate,
                    end_date = endDate,
                    color = color
                )
            )
        }
    }

    val startSaveOperation = MutableLiveData<Boolean>()

    fun startSave(){
        startSaveOperation.value=true
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
