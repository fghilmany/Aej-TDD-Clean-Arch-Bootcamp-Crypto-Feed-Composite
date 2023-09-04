package com.hightech.cryptoapp.main.factories

import com.example.cache.CryptoFeedLocalClient
import com.example.cache.CryptoFeedRoomClient
import com.hightech.cryptoapp.frameworks.LocalFactory

class CryptoFeedDaoFactory {
    companion object{
        fun createCryptoFeedDao(): CryptoFeedLocalClient {
            return CryptoFeedRoomClient(LocalFactory.createDatabase().cryptoFeedDao())
        }
    }
}