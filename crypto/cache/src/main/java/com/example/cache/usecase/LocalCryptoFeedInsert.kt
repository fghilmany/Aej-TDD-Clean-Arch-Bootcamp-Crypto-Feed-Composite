package com.example.cache.usecase

import com.example.cache.CryptoFeedLocalClient
import com.example.cache.LocalCryptoFeedItemsMapper
import com.example.cache.LocalRootCryptoFeed
import com.example.domain.CryptoFeedItem
import com.example.shared.decorator.CryptoFeedCache

class LocalCryptoFeedInsert constructor(
    private val cryptoFeedLocalClient: CryptoFeedLocalClient
): CryptoFeedCache {
    override suspend fun save(list: List<CryptoFeedItem>) {
        val data = LocalCryptoFeedItemsMapper.mapListToJsonString(list)
        cryptoFeedLocalClient.insert(
            LocalRootCryptoFeed(
                data = data
            )
        )
    }
}