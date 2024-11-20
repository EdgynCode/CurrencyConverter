package com.currencyconverter.controllers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.currencyconverter.R
import com.currencyconverter.controllers.LiveExchangeRatesFragment.Companion.localExchangeRates
import com.currencyconverter.models.SharedViewModel

class ConvertFragment : Fragment(R.layout.fragment_convert) {

    // currency dropdown menu
    private lateinit var spinnerFrom: Spinner
    private lateinit var spinnerTo: Spinner

    // edit text to enter amount
    private lateinit var etAmount: EditText

    // result text view
    private lateinit var tvResult: TextView

    // convert button
    private lateinit var btnConvert: Button

    // for accessing exchangeRates at global level
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize Views
        spinnerFrom = view.findViewById(R.id.spinnerFrom)
        spinnerTo = view.findViewById(R.id.spinnerTo)
        etAmount = view.findViewById(R.id.etAmount)
        tvResult = view.findViewById(R.id.tvResult)
        btnConvert = view.findViewById(R.id.btnConvert)

        // Observe exchange rates and update spinners
        sharedViewModel.exchangeRates.observe(viewLifecycleOwner) { rates ->
            val items = rates.map { it.currency }
            val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, items)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerFrom.adapter = adapter
            spinnerTo.adapter = adapter
            spinnerFrom.setSelection(0)
            spinnerTo.setSelection(0)
        }

        // Set Button Click Listener
        btnConvert.setOnClickListener {
            handleConversion()
        }
    }

    private fun handleConversion() {
        val fromCurrency = spinnerFrom.selectedItem.toString()
        val toCurrency = spinnerTo.selectedItem.toString()
        val amountText = etAmount.text.toString()

        // Validate Input
        if (amountText.isEmpty()) {
            tvResult.text = "Please enter an amount."
            return
        }

        val amount = amountText.toDoubleOrNull()
        if (amount == null || amount <= 0) {
            tvResult.text = "Invalid amount entered."
            return
        }

        // Find Exchange Rates
        val fromRate = localExchangeRates.find { it.currency == fromCurrency }?.rate
        val toRate = localExchangeRates.find { it.currency == toCurrency }?.rate

        if (fromRate == null || toRate == null) {
            tvResult.text = "Unable to find exchange rates."
            return
        }

        // Perform Conversion
        val baseAmount = amount / fromRate // Convert to base currency (EUR)
        val convertedAmount = baseAmount * toRate

        // Display Result
        tvResult.text = String.format("%.2f %s", convertedAmount, toCurrency)
    }
}