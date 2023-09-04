package com.hightech.cryptoapp.main.factories

import com.example.domain.CryptoFeedLoader
import com.example.shared.decorator.CryptoFeedCache
import com.example.shared.decorator.CryptoFeedCacheDecorator

class CryptoFeedDecoratorFactory {
    companion object{
        fun createCryptoFeedDecoratorFactory(
            decorator: CryptoFeedLoader,
            cache: CryptoFeedCache
        ): CryptoFeedLoader {
            return CryptoFeedCacheDecorator(decorator, cache)
        }
    }
}