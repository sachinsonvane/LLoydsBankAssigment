package com.ss.lloydsbankpoc.presentation.weasleypage.viewmodel

sealed class WeasleyEvents {
    data class ShowToastMessage(val type: String) : WeasleyEvents()
    data object GetAllWeasley : WeasleyEvents()
}