package com.example.jetpackapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackapp.viajesBD.SQLiteHelper

class DetailViewModel(private val dbHelper: SQLiteHelper) : ViewModel() {
    private val _detailText = MutableLiveData<String>()
    val detailText: LiveData<String> get() = _detailText

    private val _detailsList = MutableLiveData<List<Pair<String, String>>>()
    val detailsList: LiveData<List<Pair<String, String>>> get() = _detailsList

    init {
        _detailsList.value = dbHelper.getAllDetalles() // Cargar datos desde la base de datos
    }

    fun addDetail(detail: String, time: String) {
        dbHelper.addDetail(detail, time) // Guardar en la base de datos
        _detailsList.value = dbHelper.getAllDetalles() // Actualizar la lista de detalles
    }
}
