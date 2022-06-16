package com.stockbit.hiring.feature.cryptowatcher

import androidx.lifecycle.ViewModel
import com.stockbit.repository.CryptoRepoImpl

class CryptoWatchViewModel constructor(private val repository: CryptoRepoImpl): ViewModel() {
    fun getTopTierListCrypto() = repository.getUpdatedTopTierCrypto()
}