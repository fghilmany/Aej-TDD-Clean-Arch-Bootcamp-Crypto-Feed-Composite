package com.example.cache

import kotlinx.coroutines.flow.Flow

sealed class LocalClientResult {
    data class Success(val root: LocalRootCryptoFeed) : LocalClientResult()
    data class Failure(val throwable: Throwable) : LocalClientResult()
}

interface CryptoFeedLocalClient{
    fun get(): Flow<LocalClientResult>
    suspend fun insert(data: LocalRootCryptoFeed)
}