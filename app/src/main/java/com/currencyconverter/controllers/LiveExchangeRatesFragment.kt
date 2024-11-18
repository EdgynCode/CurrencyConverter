package com.currencyconverter.controllers

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.currencyconverter.R
import com.currencyconverter.models.ExchangeRate
import com.currencyconverter.models.SharedViewModel
import com.currencyconverter.services.ExchangeRatesService
import com.currencyconverter.views.ExchangeRatesAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LiveExchangeRatesFragment : Fragment(R.layout.fragment_exchange) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvErrorMessage: TextView
    private var apiKey = "a091355d2a6669db830a927278590768"

    private val sharedViewModel: SharedViewModel by activityViewModels()

    companion object {
        val localExchangeRates = mutableListOf<ExchangeRate>()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewExchangeRates)
        progressBar = view.findViewById(R.id.progressBar)
        tvErrorMessage = view.findViewById(R.id.tvErrorMessage)

        fetchExchangeRates()
    }

    private fun fetchExchangeRates() {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        tvErrorMessage.visibility = View.GONE

        val api = Retrofit.Builder()
            .baseUrl("https://api.exchangeratesapi.io/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExchangeRatesService::class.java)

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = api.getExchangeRates(apiKey)
                if (response.isSuccessful) {
                    val rates = response.body()?.rates
                    if (rates != null) {
                        val ratesList = cloneRates(rates)
                        displayRates(localExchangeRates)
                        updateLocalRates(ratesList)
                    } else {
                        showError("No rates available.")
                    }
                } else {
                    showError("API Error: ${response.message()}")
                }
            } catch (e: Exception) {
                showError("Network Error: ${e.localizedMessage}")
            }
        }
    }

    private fun cloneRates(rates: Map<String, Double>): List<ExchangeRate> {
        return rates.map { (currency, rate) ->
            ExchangeRate(currency, rate)
        }
    }

    private fun updateLocalRates(newRates: List<ExchangeRate>) {
        localExchangeRates.clear()
        localExchangeRates.addAll(newRates)
    }

    private fun displayRates(rates: List<ExchangeRate>) {
        sharedViewModel.exchangeRates.value = rates
        progressBar.visibility = View.GONE
        tvErrorMessage.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ExchangeRatesAdapter(rates)
    }

    private fun showError(message: String) {
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.GONE
        tvErrorMessage.visibility = View.VISIBLE
        tvErrorMessage.text = message
    }
}