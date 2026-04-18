package com.example.androidassignment.ui.screens.home

import androidx.lifecycle.ViewModel
import com.example.androidassignment.data.DummyData
import com.example.androidassignment.data.MediaSection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class HomeUiState(
    val searchInput: String = "",
    val sections: List<MediaSection> = emptyList(),
    val heroTitle: String = "IRRFAN KHAN",
    val heroLabel: String = "THE CREATIVE NETWORK ORIGINALS"
)


class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        _uiState.update {
            it.copy(
                sections = DummyData.sections
            )
        }
    }

    fun changeInput(newValue: String) {
        _uiState.update {
            it.copy(
                searchInput = newValue
            )
        }
    }

}