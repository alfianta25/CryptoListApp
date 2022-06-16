package com.stockbit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.stockbit.model.CryptoListModel
import com.stockbit.model.ExampleModel
import com.stockbit.remote.CryptoFetchDatasource
import com.stockbit.repository.utils.Crypto
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class CryptoRepoImpl constructor(private val datasource: CryptoFetchDatasource) {
    fun getUpdatedTopTierCrypto(): LiveData<Resource<List<Crypto>>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading())
            emit(datasource.getTopTierCryptoList())
        }
}