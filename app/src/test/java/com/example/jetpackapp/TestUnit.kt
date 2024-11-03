package com.example.jetpackapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class WelcomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: WelcomeViewModel

    @Before
    fun setUp() {
        viewModel = WelcomeViewModel()
    }

    @Test
    fun `initial welcome message is correct`() {
        assertEquals("Bienvenido a la App!", viewModel.welcomeMessage.value)
    }

    @Test
    fun `updateWelcomeMessage updates the message correctly`() {
        val observer = mock<Observer<String>>()
        viewModel.welcomeMessage.observeForever(observer)

        val newMessage = "Nuevo mensaje de bienvenida"
        viewModel.updateWelcomeMessage(newMessage)

        val captor = argumentCaptor<String>()
        verify(observer, times(2)).onChanged(captor.capture())

        assertEquals(newMessage, captor.lastValue)
    }
}
