package com.example.cache.usecase

import com.example.domain.CryptoFeedLoader
import com.example.domain.CryptoFeedResult
import com.example.cache.CryptoFeedLocalClient
import com.example.cache.LocalClientResult
import com.example.cache.LocalCryptoFeedItemsMapper
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
                            emit(CryptoFeedResult.Success(LocalCryptoFeedItemsMapper.map(it.root.data)))
                        }
                        is LocalClientResult.Failure -> {
                            emit(CryptoFeedResult.Failure(it.throwable))
                        }
                    }

                }
        }
    }

}