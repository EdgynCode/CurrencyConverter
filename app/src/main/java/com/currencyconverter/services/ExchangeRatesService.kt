package com.currencyconverter.services

import com.currencyconverter.models.ExchangeRatesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeRatesService {
    @GET("latest")
    suspend fun getExchangeRates(@Query("base") base: String): retrofit2.Response<ExchangeRatesResponse>
}