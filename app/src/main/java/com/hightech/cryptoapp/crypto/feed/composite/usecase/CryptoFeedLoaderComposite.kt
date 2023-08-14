package com.hightech.cryptoapp.crypto.feed.composite.usecase

import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedResult
import com.hightech.cryptoapp.crypto.feed.local.LocalRootCryptoFeed
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class CryptoFeedLoaderComposite(
    private val primary: CryptoFeedLoader,
    private val fallback: CryptoFeedLoader,
): CryptoFeedLoader {
    override fun load(): Flow<CryptoFeedResult> {
        return flow {
            primary.load().collect{
                when(it) {
                    is CryptoFeedResult.Success -> emit(it)
                    is CryptoFeedResult.Failure -> emit(fallback.load().first())
                }
            }
        }
    }

    override suspend fun insert(data: LocalRootCryptoFeed) {
        primary.insert(data)
    }
}