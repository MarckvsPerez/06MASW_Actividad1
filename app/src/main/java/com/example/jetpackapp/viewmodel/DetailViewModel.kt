package com.example.jetpackapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {

    // LiveData para almacenar el texto de detalles iniciales
    private val _detailText = MutableLiveData("Detalles iniciales")
    val detailText: LiveData<String> = _detailText

    // LiveData para almacenar una lista de detalles
    private val _detailsList = MutableLiveData<List<String>>(listOf("Detalle 1", "Detalle 2"))
    val detailsList: LiveData<List<String>> = _detailsList

    // Función para actualizar un detalle
    fun updateDetail(newDetail: String) {
        _detailText.value = newDetail
    }

    // Función para añadir un nuevo detalle a la lista
    fun addDetail(newDetail: String) {
        val currentList = _detailsList.value ?: emptyList()
        _detailsList.value = currentList + newDetail
    }
}
