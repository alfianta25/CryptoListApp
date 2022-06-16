package com.stockbit.remote

import com.stockbit.model.CryptoListModel
import retrofit2.Response
import retrofit2.http.GET

interface CryptoFetchService {
    @GET("get/example")
    fun fetchCryptoListAsync(): Response<CryptoListModel>
}