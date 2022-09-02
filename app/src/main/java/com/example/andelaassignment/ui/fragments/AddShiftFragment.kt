package com.example.andelaassignment.ui.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.andelaassignment.R
import com.example.andelaassignment.databinding.FragmentAddShiftBinding
import com.example.andelaassignment.presentation.AddShiftViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class AddShiftFragment : Fragment() {

    private val viewModel: AddShiftViewModel by viewModels()

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        val inflater: MenuInflater = requireActivity().menuInflater
        inflater.inflate(R.menu.add_shift_options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.save_shift_menu -> viewModel.startSave()
        }
        return super.onOptionsItemSelected(item)

    }

    fun openDatePickerDialog(sender: TextView){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { view, year, monthOfYear, dayOfMonth ->
                var month = "${monthOfYear+1}"
                month = if(month.length==2) month else "0$month"

                var day = "$dayOfMonth"
                day = if(day.length==2) day else "0$day"
                val dat = "$year-${(month)}-${day}  9:00:00"
                sender.text = dat
            },
            year,
            month,
            day
        )
        // at last we are calling show
        // to display our date picker dialog.
        datePickerDialog.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentAddShiftBinding>(
            inflater,
            R.layout.fragment_add_shift, container, false
        )


        viewModel.startSaveOperation.observe(this){
            viewModel.addShift(
                startDate = binding.startDateTextInput.text.toString(),
                endDate = binding.endDateTextInput.text.toString(),
                role = binding.roleSpinner.selectedItem.toString(),
                name = binding.employeeSpinner.selectedItem.toString(),
                color = binding.colorSpinner.selectedItem.toString()
            )
            findNavController().navigateUp()
        }

        binding.startDateTextInput.setOnFocusChangeListener {
                view, hasFocus -> if(hasFocus)
                openDatePickerDialog(binding.startDateTextInput)
        }

        binding.endDateTextInput.setOnFocusChangeListener {
                view, hasFocus -> if(hasFocus)
            openDatePickerDialog(binding.endDateTextInput)
        }

        setHasOptionsMenu(true);
        binding.viewModel = viewModel
        return binding.root
    }
}
