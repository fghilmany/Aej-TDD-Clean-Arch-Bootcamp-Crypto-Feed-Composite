package com.hightech.cryptoapp.main.factories

import com.example.domain.CryptoFeedLoader
import com.example.http.usecases.RemoteCryptoFeedLoader

class CryptoFeedRemoteLoaderFactory {
    companion object {
        fun createRemoteCryptoFeedLoader(): CryptoFeedLoader {
            return RemoteCryptoFeedLoader(
                CryptoFeedHttpClientFactory.createCryptoFeedHttpClient()
            )
        }
    }
}