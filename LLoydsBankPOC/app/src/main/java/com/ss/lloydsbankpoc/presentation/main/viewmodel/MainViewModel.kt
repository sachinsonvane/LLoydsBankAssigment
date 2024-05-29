package com.ss.lloydsbankpoc.presentation.main.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(MainState())
    val state: State<MainState> = _state

    private val _mainChannel = Channel<MainChannel>()
    val mainChannel = _mainChannel.receiveAsFlow()


    fun onEvent(events: MainEvents) {
       /* when (events) {
            is MainEvents.SelectedBottomBar -> {
                _state.value = _state.value.copy(bottomBar = events.bottomBar)
            }

            is MainEvents.ShowBottomBar -> {
                _state.value = _state.value.copy(showBottomBar = events.showBottomBar)
            }
        }*/
    }
}

sealed class MainChannel {
    data class ShowErrorToast(val message: String) : MainChannel()
    data class ShowSuccessToast(val message: String) : MainChannel()
}