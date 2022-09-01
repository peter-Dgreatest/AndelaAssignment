package com.example.andelaassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.andelaassignment.R
import com.example.andelaassignment.databinding.FragmentShiftListBinding
import com.example.andelaassignment.presentation.ShiftListViewModel
import com.example.andelaassignment.ui.adapter.ShiftListAdapter
import com.example.andelaassignment.ui.mappers.ShiftPresentationToUiModelMapper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ShiftListFragment : Fragment() {

    private val viewModel: ShiftListViewModel by viewModels()
    private lateinit var shiftListAdapter: ShiftListAdapter

    @Inject
    lateinit var shiftPresentationToUiModelMapper: ShiftPresentationToUiModelMapper


    companion object {
        fun newInstance() = ShiftListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShiftListBinding>(
            inflater,
            R.layout.fragment_shift_list, container, false
        )



        shiftListAdapter = ShiftListAdapter()

        binding.shiftListView.adapter = shiftListAdapter

        // binding.rcyView.adapter = invoicesAdapter

        viewModel.shifts.observe(this) {
            val shifts = it.map { shift -> shiftPresentationToUiModelMapper.toUi(shift) }
            shiftListAdapter.mListRef = shifts
            shiftListAdapter.submitList(shifts)
        }

//        binding.addNewInvoice.setOnClickListener {
//            showModal()
//            startActivity(Intent(this.activity, FeesSelectActivity::class.java))
//        }

        binding.viewmodel = viewModel
        return binding.root
    }
}
