package com.example.androidassignment.ui.screens.detail

import androidx.lifecycle.ViewModel
import com.example.androidassignment.data.DummyData
import com.example.androidassignment.data.MediaItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class DetailUiState(
    val media: MediaItem = DummyData.defaultMedia,
    val selectedTab: Int = 0
)


class DetailViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()


    fun loadMovie(movieId: String) {
        _uiState.update { it.copy(media = DummyData.findById(movieId)) }
    }

}