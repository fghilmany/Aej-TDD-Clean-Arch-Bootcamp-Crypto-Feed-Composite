package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.local.usecase.LocalCryptoFeedInsert
import com.hightech.cryptoapp.main.decorator.CryptoFeedCache

class CryptoFeedLocalInsertFactory {
    companion object {
        fun createLocalCryptoFeedLoader(): CryptoFeedCache {
            return LocalCryptoFeedInsert(CryptoFeedDaoFactory.createCryptoFeedDao())
        }

    }
}