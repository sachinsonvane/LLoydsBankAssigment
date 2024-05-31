package com.ss.lloydsbankpoc.presentation.weasleypage.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ss.lloydsbankpoc.App
import com.ss.lloydsbankpoc.R
import com.ss.lloydsbankpoc.common.showMessage
import com.ss.lloydsbankpoc.data.models.allevents.WeasleyEvents
import com.ss.lloydsbankpoc.data.models.allstates.WeasleyState
import com.ss.lloydsbankpoc.data.repository.WeasleyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeasleyViewModel @Inject constructor(private val weasleyRepository: WeasleyRepository
) : ViewModel() {

    private val _state = mutableStateOf(WeasleyState())
    val state: State<WeasleyState> = _state

    val allWeasley = weasleyRepository.allWeasley

    fun onEvent(events: WeasleyEvents) {
        when (events) {
            is WeasleyEvents.GetAllWeasley -> {
                viewModelScope.launch {
                    weasleyRepository.refreshWeasley()
                    getAllWeasley()
                }
            }
            is WeasleyEvents.ShowToastMessage -> {
                showMessage(App.instance.resources.getResourceName(R.string.error_str))
            }
        }
    }

    private suspend fun getAllWeasley() {
        weasleyRepository.allWeasley.collect {
            _state.value = _state.value.copy(allWeasleyData = it)
        }
    }

}