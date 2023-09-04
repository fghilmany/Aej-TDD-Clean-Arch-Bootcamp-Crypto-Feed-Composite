package com.hightech.cryptoapp.main.factories

import com.example.cache.usecase.LocalCryptoFeedInsert
import com.example.shared.decorator.CryptoFeedCache

class CryptoFeedLocalInsertFactory {
    companion object {
        fun createLocalCryptoFeedLoader(): CryptoFeedCache {
            return LocalCryptoFeedInsert(CryptoFeedDaoFactory.createCryptoFeedDao())
        }

    }
}