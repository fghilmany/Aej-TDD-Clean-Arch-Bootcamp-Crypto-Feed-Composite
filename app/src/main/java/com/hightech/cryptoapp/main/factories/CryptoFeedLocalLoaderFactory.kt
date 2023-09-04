package com.hightech.cryptoapp.main.factories

import com.example.shared.composite.CryptoFeedLoaderComposite
import com.example.cache.usecase.LocalCryptoFeedLoader
import com.example.domain.CryptoFeedLoader

class CryptoFeedLocalLoaderFactory {
    companion object {
        fun createLocalCryptoFeedLoader(): CryptoFeedLoader {
            return LocalCryptoFeedLoader(CryptoFeedDaoFactory.createCryptoFeedDao())
        }
    }
}