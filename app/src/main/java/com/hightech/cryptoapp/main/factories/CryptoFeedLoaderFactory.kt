package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.composite.usecase.CryptoFeedLoaderComposite
import com.hightech.cryptoapp.crypto.feed.local.usecase.LocalCryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.http.usecases.RemoteCryptoFeedLoader

class CryptoFeedLoaderFactory {
    companion object {
        fun createRemoteCryptoFeedLoader(): CryptoFeedLoader {
            return RemoteCryptoFeedLoader(
                CryptoFeedHttpClientFactory.createCryptoFeedHttpClient(),
                CryptoFeedDaoFactory.createCryptoFeedDao()
            )
        }
        fun createLocalCryptoFeedLoader(): CryptoFeedLoader {
            return LocalCryptoFeedLoader(CryptoFeedDaoFactory.createCryptoFeedDao())
        }
        fun createCompositeFactory(
            primary: CryptoFeedLoader,
            fallback: CryptoFeedLoader
        ): CryptoFeedLoader{
            return CryptoFeedLoaderComposite(primary, fallback)
        }
    }
}