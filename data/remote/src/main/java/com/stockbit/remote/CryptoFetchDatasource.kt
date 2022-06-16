package com.stockbit.remote

import com.stockbit.model.CryptoListModel
import com.stockbit.repository.utils.Crypto
import com.stockbit.repository.utils.Resource
import retrofit2.Response

class CryptoFetchDatasource constructor(private val cryptoFetchService: CryptoFetchService) {

    suspend fun getTopTierCryptoList() = getResult {
        cryptoFetchService.fetchCryptoListAsync()
    }

    protected suspend fun getResult(call: suspend () -> Response<CryptoListModel>): Resource<List<Crypto>> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    if (it.type != 100)
                        return Resource.error(it.message)
                    else
                        return Resource.success(bridgeToListOfStock(it))
                }
            }
            return Resource.error("Failed to connect")
        } catch (e: Exception) {
            return Resource.error(e.message ?: e.toString())
        }
    }

    private fun bridgeToListOfStock(response: CryptoListModel): List<Crypto> {
        return response.data.map {
            Crypto(
                name = it.coinInfo.name,
                companyName = it.coinInfo.fullName,
                currentValue = it.rAW.uSD.pRICE,
                openValue = it.rAW.uSD.oPENDAY
            )
        }
    }
}