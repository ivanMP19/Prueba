package com.example.prueba.data.remote

import com.example.prueba.data.entities.SearchModelList
import com.example.prueba.utils.Constantes.PAGE_REQUEST_PARAM
import com.example.prueba.utils.Constantes.SEARCH_REQUEST_PARAM
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //search products
    @GET(".")
    suspend fun getProducts(@Query(SEARCH_REQUEST_PARAM) search:String, @Query(PAGE_REQUEST_PARAM) page:Int):Response<SearchModelList>

}
