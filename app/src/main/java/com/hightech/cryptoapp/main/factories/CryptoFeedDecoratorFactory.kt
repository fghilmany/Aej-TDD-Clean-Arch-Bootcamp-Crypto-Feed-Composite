package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.main.decorator.CryptoFeedCache
import com.hightech.cryptoapp.main.decorator.CryptoFeedCacheDecorator

class CryptoFeedDecoratorFactory {
    companion object{
        fun createCryptoFeedDecoratorFactory(
            decorator: CryptoFeedLoader,
            cache: CryptoFeedCache
        ): CryptoFeedLoader{
            return CryptoFeedCacheDecorator(decorator, cache)
        }
    }
}