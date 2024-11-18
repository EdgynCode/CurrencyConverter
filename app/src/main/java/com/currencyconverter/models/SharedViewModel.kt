package com.currencyconverter.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val exchangeRates = MutableLiveData<List<ExchangeRate>>()
}