package com.example.shared.decorator

import com.example.domain.CryptoFeedItem
import com.example.domain.CryptoFeedLoader
import com.example.domain.CryptoFeedResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


interface CryptoFeedCache{
    suspend fun save(list: List<CryptoFeedItem>)
}
class CryptoFeedCacheDecorator(
    private val decorator: CryptoFeedLoader,
    private val cache: CryptoFeedCache
): CryptoFeedLoader {
    override fun load(): Flow<CryptoFeedResult> {
        return flow{
            decorator.load().collect{result ->
                if (result is CryptoFeedResult.Success){
                    cache.save(result.cryptoFeedItems)
                }
                emit(result)
            }
        }
    }

}