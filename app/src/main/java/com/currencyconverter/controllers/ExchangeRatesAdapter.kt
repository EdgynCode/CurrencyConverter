package com.currencyconverter.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.currencyconverter.R
import com.currencyconverter.models.ExchangeRate

class ExchangeRatesAdapter(private val rates: List<ExchangeRate>) :
    RecyclerView.Adapter<ExchangeRatesAdapter.ExchangeRateViewHolder>() {
    class ExchangeRateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCurrencyName: TextView = itemView.findViewById(R.id.tvCurrencyName)
        val tvExchangeRate: TextView = itemView.findViewById(R.id.tvExchangeRate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeRateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exchange_rate, parent, false)
        return ExchangeRateViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExchangeRateViewHolder, position: Int) {
        val rate = rates[position]
        holder.tvCurrencyName.text = rate.currency
        holder.tvExchangeRate.text = rate.rate.toString()
    }

    override fun getItemCount(): Int = rates.size
}