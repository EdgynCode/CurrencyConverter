package com.currencyconverter.services

import com.currencyconverter.models.ExchangeRatesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeRatesService {
    @GET("latest")
    suspend fun getExchangeRates(@Query("access_key") accessKey: String): retrofit2.Response<ExchangeRatesResponse>
}