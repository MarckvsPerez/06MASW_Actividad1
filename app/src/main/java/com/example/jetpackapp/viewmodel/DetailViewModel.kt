package com.example.jetpackapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {

    // LiveData para almacenar algún detalle
    private val _detailText = MutableLiveData("Detalles iniciales")
    val detailText: LiveData<String> = _detailText

    // Función para actualizar los detalles
    fun updateDetail(newDetail: String) {
        _detailText.value = newDetail
    }
}
