package com.hightech.cryptoapp.main.factories

import com.example.shared.composite.CryptoFeedLoaderComposite
import com.example.domain.CryptoFeedLoader

class CryptoFeedCompositeFactory {
    companion object {
        fun createCompositeFactory(
            primary: CryptoFeedLoader,
            fallback: CryptoFeedLoader
        ): CryptoFeedLoader {
            return CryptoFeedLoaderComposite(primary, fallback)
        }
    }
}