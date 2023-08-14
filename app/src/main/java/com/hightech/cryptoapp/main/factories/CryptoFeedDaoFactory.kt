package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.local.CryptoFeedLocalClient
import com.hightech.cryptoapp.crypto.feed.local.CryptoFeedRoomClient
import com.hightech.cryptoapp.frameworks.LocalFactory

class CryptoFeedDaoFactory {
    companion object{
        fun createCryptoFeedDao(): CryptoFeedLocalClient{
            return CryptoFeedRoomClient(LocalFactory.createDatabase().cryptoFeedDao())
        }
    }
}