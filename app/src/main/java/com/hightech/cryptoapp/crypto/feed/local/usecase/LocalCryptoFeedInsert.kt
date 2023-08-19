package com.hightech.cryptoapp.crypto.feed.local.usecase

import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedItem
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedItemsMapper
import com.hightech.cryptoapp.crypto.feed.local.CryptoFeedLocalClient
import com.hightech.cryptoapp.crypto.feed.local.LocalRootCryptoFeed
import com.hightech.cryptoapp.main.decorator.CryptoFeedCache

class LocalCryptoFeedInsert constructor(
    private val cryptoFeedLocalClient: CryptoFeedLocalClient
): CryptoFeedCache {
    override suspend fun save(list: List<CryptoFeedItem>) {
        val data = CryptoFeedItemsMapper.mapListToJsonString(list)
        cryptoFeedLocalClient.insert(
            LocalRootCryptoFeed(
                data = data
            )
        )
    }
}