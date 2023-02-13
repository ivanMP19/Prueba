package com.example.prueba.data.remote

class RemoteDataSource constructor(
    private val apiService: ApiService
): BaseDataSource() {

    suspend fun getProducts(search:String,page:Int) = getResult { apiService.getProducts(search,page) }
}