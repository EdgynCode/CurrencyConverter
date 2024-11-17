package com.currencyconverter.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.currencyconverter.R

class ExchangeRatesAdapter(private val rates: Map<String, Double>) :
    RecyclerView.Adapter<ExchangeRatesAdapter.ExchangeRateViewHolder>() {
    class ExchangeRateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCurrencyName: TextView = itemView.findViewById(R.id.tvCurrencyName)
        private val tvExchangeRate: TextView = itemView.findViewById(R.id.tvExchangeRate)

        fun bind(currency: String, rate: Double) {
            tvCurrencyName.text = currency
            tvExchangeRate.text = rate.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeRateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exchange_rate, parent, false)
        return ExchangeRateViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExchangeRateViewHolder, position: Int) {
        val currency = rates.keys.elementAt(position)
        val rate = rates[currency]
        holder.bind(currency, rate ?: 0.0)
    }

    override fun getItemCount(): Int = rates.size
}