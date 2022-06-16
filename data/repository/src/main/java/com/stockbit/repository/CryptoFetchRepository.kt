package com.stockbit.repository

import com.stockbit.model.CryptoListModel
import com.stockbit.model.ExampleModel
import com.stockbit.remote.CryptoFetchDatasource
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface CryptoFetchRepository {
    suspend fun getCryptoList(): Flow<Resource<CryptoListModel>>
}

class CryptoRepoImpl(private val datasource: CryptoFetchDatasource):CryptoFetchRepository  {
    override suspend fun getCryptoList(): Flow<Resource<CryptoListModel>> {
        return flow {  }
    }
}