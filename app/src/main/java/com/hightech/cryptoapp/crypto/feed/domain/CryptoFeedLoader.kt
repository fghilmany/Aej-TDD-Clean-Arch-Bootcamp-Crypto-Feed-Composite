package com.hightech.cryptoapp.crypto.feed.domain

import com.hightech.cryptoapp.crypto.feed.local.LocalRootCryptoFeed
import kotlinx.coroutines.flow.Flow

sealed class CryptoFeedResult {
    data class Success(val cryptoFeedItems: List<CryptoFeedItem>) : CryptoFeedResult()
    data class Failure(val throwable: Throwable) : CryptoFeedResult()
}

interface CryptoFeedLoader {
    fun load(): Flow<CryptoFeedResult>
}