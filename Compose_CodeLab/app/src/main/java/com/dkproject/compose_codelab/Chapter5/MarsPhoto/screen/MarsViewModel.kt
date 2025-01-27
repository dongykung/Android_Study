package com.dkproject.compose_codelab.Chapter5.MarsPhoto.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.dkproject.compose_codelab.Chapter5.MarsPhoto.MarsPhotosApplication
import com.dkproject.compose_codelab.Chapter5.MarsPhoto.data.MarsPhoto
import com.dkproject.compose_codelab.Chapter5.MarsPhoto.data.MarsPhotosRepository
import com.dkproject.compose_codelab.Chapter5.MarsPhoto.data.NetworkMarsPhotosRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MarsViewModel(
    private val marsPhotosRepository: MarsPhotosRepository
) : ViewModel() {
    var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)
        private set

    init {
        getMarsPhotos()
    }

    fun getMarsPhotos() {
        viewModelScope.launch {
            marsUiState = try {
                val listResult = marsPhotosRepository.getMarsPhotos()
                MarsUiState.Success(listResult)
            } catch (e:IOException) {
                MarsUiState.Error
            } catch (e: HttpException) {
                MarsUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MarsPhotosApplication)
                val marsPhotosRepository = application.container.marsPhotosRepository
                MarsViewModel(marsPhotosRepository = marsPhotosRepository)
            }
        }
    }
}

sealed interface MarsUiState {
    data class Success(val photos: List<MarsPhoto>): MarsUiState
    data object Loading: MarsUiState
    data object Error: MarsUiState
}