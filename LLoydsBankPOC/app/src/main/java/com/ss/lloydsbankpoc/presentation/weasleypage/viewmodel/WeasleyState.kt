package com.ss.lloydsbankpoc.presentation.weasleypage.viewmodel

import com.ss.lloydsbankpoc.data.models.roommodel.WeasleyTable

data class WeasleyState(
    val allWeasleyData: List<WeasleyTable> = listOf()
)