package com.stockbit.remote

class CryptoFetchDatasource (private val cryptoFetchService: CryptoFetchService) {
    fun fetchCryptoList() =
        cryptoFetchService.fetchCryptoListAsync()
}