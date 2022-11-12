package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.criminalintent.database.KoalaDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

class CrimeDetailViewModel(crimeId: UUID) : ViewModel() {
    private val crimeRepository = CrimeRepository.get()

    private val _koala: MutableStateFlow<Koala?> = MutableStateFlow(null)
    val koala: StateFlow<Koala?> = _koala.asStateFlow()

    init {
        viewModelScope.launch {
            _koala.value = crimeRepository.getCrime(crimeId)
        }
    }

    fun updateCrime(onUpdate: (Koala) -> Koala) {
        _koala.update { oldCrime ->
            oldCrime?.let { onUpdate(it) }
        }
    }

    override fun onCleared() {
        super.onCleared()
        koala.value?.let { crimeRepository.updateCrime(it) }
    }


}

class CrimeDetailViewModelFactory(
    private val crimeId: UUID
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CrimeDetailViewModel(crimeId) as T
    }
}
