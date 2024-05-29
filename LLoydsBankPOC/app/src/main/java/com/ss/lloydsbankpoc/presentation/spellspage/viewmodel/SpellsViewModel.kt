package com.ss.lloydsbankpoc.presentation.spellspage.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ss.lloydsbankpoc.data.repository.SpellsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SpellsViewModel @Inject constructor(private val spellsRepository: SpellsRepository
) : ViewModel() {

    private val _state = mutableStateOf(SpellsStates())
    val state: State<SpellsStates> = _state

    val allSpells = spellsRepository.allSpells

    fun onEvent(events: SpellsEvents) {
        when (events) {
            is SpellsEvents.GetAllSpells -> {
                viewModelScope.launch {
                    spellsRepository.refreshSpells()
                    getAllSpells()
                }
            }
            is SpellsEvents.ShowToastMessage -> {
                /*  if (events.type == application.getString(R.string.ocean))
                      Toast.makeText(application, "${_state.value.allOceanData}", Toast.LENGTH_SHORT)
                          .show()
                  else
                      Toast.makeText(application, "${_state.value.allWoodsData}", Toast.LENGTH_SHORT)
                          .show()*/
            }
        }
    }

    private suspend fun getAllSpells() {
        spellsRepository.allSpells.collect {
            _state.value = _state.value.copy(allSpellsData = it)
        }
    }

}