package com.example.prueba.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName ="products")
data class ProductModel(
    @PrimaryKey @ColumnInfo(name = "productId") @SerializedName(value = "productId")  val productId: String,
    @ColumnInfo(name = "productDisplayName") @SerializedName(value="productDisplayName")  val productDisplayName: String,
    @ColumnInfo(name = "smImage") @SerializedName(value="smImage")  val smImage: String,
    @ColumnInfo(name = "listPrice") @SerializedName(value="listPrice")  val listPrice: Double,
    @ColumnInfo(name = "promoPrice") @SerializedName(value="promoPrice")  val promoPrice: Double,
    @ColumnInfo(name = "variantsColor") @SerializedName(value="variantsColor")  val variantsColor: ArrayList<VariantColorModel>

    )