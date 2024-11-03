package com.example.jetpackapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalTime

class DetailViewModel : ViewModel() {

    // LiveData para almacenar el texto de detalles iniciales
    private val _detailText = MutableLiveData("Detalles iniciales")
    val detailText: LiveData<String> = _detailText

    // LiveData para almacenar una lista de detalles
    private val _detailsList = MutableLiveData<List<Pair<String, LocalTime>>>(emptyList())
    val detailsList: LiveData<List<Pair<String, LocalTime>>> = _detailsList

    // Función para actualizar un detalle
    fun updateDetail(newDetail: String) {
        _detailText.value = newDetail
    }

    // Función para añadir un nuevo detalle a la lista
    fun addDetail(newDetail: String, newTime: LocalTime) {
        val currentList = _detailsList.value ?: emptyList()
        _detailsList.value = currentList + Pair(newDetail, newTime)
    }
}
