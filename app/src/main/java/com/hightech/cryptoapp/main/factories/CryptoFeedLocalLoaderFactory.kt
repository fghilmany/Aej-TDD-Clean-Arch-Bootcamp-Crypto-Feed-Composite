package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.local.usecase.LocalCryptoFeedLoader

class CryptoFeedLocalLoaderFactory {
    companion object {
        fun createLocalCryptoFeedLoader(): CryptoFeedLoader {
            return LocalCryptoFeedLoader(CryptoFeedDaoFactory.createCryptoFeedDao())
        }
    }
}