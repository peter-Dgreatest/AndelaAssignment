package com.example.andelaassignment.ui.adapter

import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import com.example.andelaassignment.R

@BindingAdapter("bindSpinner")
fun Spinner.bindSpiner(entries: ArrayList<String>) {
    val arrayAdapter: ArrayAdapter<String> =
        ArrayAdapter(
            this.context,
            R.layout.my_selected_item,
            entries ?: listOf("")
        )
    arrayAdapter.setDropDownViewResource(R.layout.my_dropdown_item)
    this.setAdapter(arrayAdapter)
}
