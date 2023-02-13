package com.example.prueba.utils

import androidx.room.TypeConverter
import com.example.prueba.data.entities.VariantColorModel
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun listToJson(value: List<VariantColorModel>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<VariantColorModel>::class.java).toList()
}