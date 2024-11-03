package com.example.jetpackapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
<<<<<<< HEAD
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
=======
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
>>>>>>> 24456589e915db97c1b9e2a8aca60deb332ec98f
    }
}
