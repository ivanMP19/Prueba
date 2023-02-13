package com.example.prueba.data.entities

import com.google.gson.annotations.SerializedName

data class VariantColorModel(
    @SerializedName(value = "colorName")  val colorName: String,
    @SerializedName(value = "colorHex")  val colorHex: String,
    @SerializedName(value = "colorImageURL")  val colorImageURL: String
)
