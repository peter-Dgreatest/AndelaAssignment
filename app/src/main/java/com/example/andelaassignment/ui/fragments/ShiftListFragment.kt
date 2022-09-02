package com.example.andelaassignment.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        val inflater: MenuInflater = requireActivity().menuInflater
        inflater.inflate(R.menu.my_options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_shift_menu -> viewModel.onNavigate()
        }
        return super.onOptionsItemSelected(item)

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
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)


        shiftListAdapter = ShiftListAdapter()

        binding.shiftListView.adapter = shiftListAdapter

        viewModel.navigateToNextActivity.observe(this){
            if(it) {
                findNavController().navigate(
                    ShiftListFragmentDirections.actionShiftListFragmentToAddShiftFragment()
                )
                viewModel.endNavigation()
            }
        }

        viewModel.shifts.observe(this) {
            val shifts = it?.map { shift -> shiftPresentationToUiModelMapper.toUi(shift) }
            shiftListAdapter.mListRef = shifts
            shiftListAdapter.submitList(shifts)
        }

        binding.viewmodel = viewModel
        return binding.root
    }
}
