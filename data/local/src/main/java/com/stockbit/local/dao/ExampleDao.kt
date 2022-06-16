package com.stockbit.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.stockbit.model.CryptoListModel
import com.stockbit.model.ExampleModel
import java.util.*

@Dao
abstract class ExampleDao: BaseDao<ExampleModel>() {

    @Query("SELECT * FROM CryptoListModel WHERE data = data LIMIT 50")
    abstract suspend fun getListCrypto(name: String): CryptoListModel

//    suspend fun save(data: CryptoListModel) {
//        insert(users = data)
//    }

//    suspend fun save(datas: List<CryptoListModel>) {
//        insert(users = datas)
//    }
}