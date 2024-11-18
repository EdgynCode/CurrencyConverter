package com.currencyconverter.controllers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.currencyconverter.R

class ConvertFragment : Fragment(R.layout.fragment_convert) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinnerFrom: Spinner = view.findViewById(R.id.spinnerFrom)
        val spinnerTo: Spinner = view.findViewById(R.id.spinnerTo)
        val items = listOf("EUR", "USD", "GBP")
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerFrom.adapter = adapter
        spinnerTo.adapter = adapter
        spinnerFrom.setSelection(0)
        spinnerTo.setSelection(0)
    }
}