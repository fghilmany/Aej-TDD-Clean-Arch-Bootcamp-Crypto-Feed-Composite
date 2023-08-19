package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.composite.usecase.CryptoFeedLoaderComposite
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader

class CryptoFeedCompositeFactory {
    companion object {
        fun createCompositeFactory(
            primary: CryptoFeedLoader,
            fallback: CryptoFeedLoader
        ): CryptoFeedLoader{
            return CryptoFeedLoaderComposite(primary, fallback)
        }
    }
}