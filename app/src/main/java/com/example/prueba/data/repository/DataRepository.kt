package com.example.prueba.data.repository

import com.example.prueba.data.local.ProductsDao
import com.example.prueba.data.remote.RemoteDataSource
import com.example.prueba.utils.performGetOperation
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: ProductsDao
){
    fun getProducts(search: String) = performGetOperation(
        databaseQuery = { localDataSource.getAllProducts() },
        networkCall = { remoteDataSource.getProducts(search,1) },
        saveCallResult = { localDataSource.insertAll(it.plpResults.records) }
    )

}