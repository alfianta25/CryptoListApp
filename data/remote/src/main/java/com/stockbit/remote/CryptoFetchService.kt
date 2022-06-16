package com.stockbit.remote

import com.stockbit.model.CryptoListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoFetchService {
    @GET("data/top/totaltoptiervolfull")
    suspend fun fetchCryptoListAsync(@Query("limit") limit: Int = 50, @Query("tsym") currency: String = "USD"): Response<CryptoListModel>
}