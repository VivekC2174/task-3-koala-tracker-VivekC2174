package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class KoalaListViewModel : ViewModel() {
    private val crimeRepository = CrimeRepository.get()

    private val _crimes: MutableStateFlow<List<Koala>> = MutableStateFlow(emptyList())
    val crimes: StateFlow<List<Koala>>
        get() = _crimes.asStateFlow()

    init {
        viewModelScope.launch {
            crimeRepository.getCrimes().collect {
                _crimes.value = it
            }
        }
    }

    suspend fun addCrime(koala: Koala) {
        crimeRepository.addCrime(koala)
    }
}
