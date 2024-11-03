package com.example.jetpackapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    // LiveData para el mensaje de bienvenida
    private val _welcomeMessage = MutableLiveData("Bienvenido a la App!")
    val welcomeMessage: LiveData<String> = _welcomeMessage

    // Función para actualizar el mensaje de bienvenida
    fun updateWelcomeMessage(newMessage: String) {
        _welcomeMessage.value = newMessage
    }
}
