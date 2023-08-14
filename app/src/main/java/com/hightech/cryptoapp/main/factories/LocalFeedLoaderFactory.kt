package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader

class LocalFeedLoaderFactory {
    companion object{
        fun createLocalCryptoFeedLoader(): CryptoFeedLoader{
            return LocalFeedLoaderFactory.createLocalCryptoFeedLoader()
        }
    }
}