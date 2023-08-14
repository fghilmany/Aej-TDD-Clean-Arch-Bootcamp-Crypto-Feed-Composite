package com.hightech.cryptoapp.crypto.feed.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class CryptoFeedRoomClient constructor(
    private val cryptoDao: CryptoFeedDao
): CryptoFeedLocalClient {
    override fun get(): Flow<LocalClientResult> {
        return flow {
            cryptoDao.load()
                .catch {
                    emit(LocalClientResult.Failure(it))
                }.collect{
                    emit(LocalClientResult.Success(it))
                }
        }
    }

    override suspend fun insert(data: LocalRootCryptoFeed) {
        cryptoDao.insert(data)
    }
}