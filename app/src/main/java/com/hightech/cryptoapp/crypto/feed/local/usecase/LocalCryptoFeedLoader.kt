package com.hightech.cryptoapp.crypto.feed.local.usecase

import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedItemsMapper
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedResult
import com.hightech.cryptoapp.crypto.feed.local.CryptoFeedLocalClient
import com.hightech.cryptoapp.crypto.feed.local.LocalClientResult
import com.hightech.cryptoapp.crypto.feed.local.LocalRootCryptoFeed
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class LocalCryptoFeedLoader constructor(private val cryptoFeedLocalClient: CryptoFeedLocalClient):
    CryptoFeedLoader {
    override fun load(): Flow<CryptoFeedResult> {
        return flow {
            cryptoFeedLocalClient.get()
                .catch {
                    emit(CryptoFeedResult.Failure(it))
                }
                .collect{
                    when(it){
                        is LocalClientResult.Success -> {
                            emit(CryptoFeedResult.Success(CryptoFeedItemsMapper.map(it.root.data)))
                        }
                        is LocalClientResult.Failure -> {
                            emit(CryptoFeedResult.Failure(it.throwable))
                        }
                    }

                }
        }
    }

    override suspend fun insert(data: LocalRootCryptoFeed) {
        cryptoFeedLocalClient.insert(data)
    }

}