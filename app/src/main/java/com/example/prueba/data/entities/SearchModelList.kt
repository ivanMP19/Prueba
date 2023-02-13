package com.example.prueba.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchModelList(
    @SerializedName(value = "status") @Expose val status:Status,
    @SerializedName(value = "pageType") @Expose val pageType: String,
    @SerializedName(value = "plpResults") @Expose val plpResults: PlpResults
    ){

    data class Status (
        @SerializedName(value = "status") @Expose val status:String,
        @SerializedName(value = "statusCode") @Expose val statusCode: Int,
    )

    data class PlpResults(
        @SerializedName(value = "label") @Expose val label:String,
        @SerializedName(value = "records") @Expose val records: ArrayList<ProductModel>
        )
}
