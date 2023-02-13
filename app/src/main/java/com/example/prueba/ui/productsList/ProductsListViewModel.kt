package com.example.prueba.ui.productsList

import androidx.lifecycle.ViewModel
import com.example.prueba.data.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(private val repository: DataRepository):ViewModel() {
    val movies = repository.getProducts()
}