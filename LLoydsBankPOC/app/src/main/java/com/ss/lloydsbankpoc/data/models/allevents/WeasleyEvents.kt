package com.ss.lloydsbankpoc.data.models.allevents

sealed class WeasleyEvents {
    data class ShowToastMessage(val type: String) : WeasleyEvents()
    data object GetAllWeasley : WeasleyEvents()
}