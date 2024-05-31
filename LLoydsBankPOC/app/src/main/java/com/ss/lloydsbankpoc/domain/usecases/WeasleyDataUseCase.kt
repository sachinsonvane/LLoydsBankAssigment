package com.ss.lloydsbankpoc.domain.usecases

import com.ss.lloydsbankpoc.data.models.roommodel.WeasleyTable
import com.ss.lloydsbankpoc.data.repository.WeasleyRepository
import kotlinx.coroutines.flow.Flow

class WeasleyDataUseCase(weasleyRepository: WeasleyRepository) {

    private val allWeasley = weasleyRepository.allWeasley
    operator fun invoke(): Flow<List<WeasleyTable>> {
        return  allWeasley
    }
}