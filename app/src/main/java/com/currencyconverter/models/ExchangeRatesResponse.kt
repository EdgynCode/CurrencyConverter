package com.currencyconverter.models

data class ExchangeRatesResponse (
    val base: String,
    val rates: Map<String, Double>
)