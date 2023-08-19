package com.hightech.cryptoapp.crypto.feed.domain

import android.util.Log
import com.hightech.cryptoapp.crypto.feed.http.RemoteCryptoFeedItem
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


class CryptoFeedItemsMapper {
    companion object {
        fun map(items: List<RemoteCryptoFeedItem>): List<CryptoFeedItem> {
            return items.map {
                CryptoFeedItem(
                    coinInfo = CoinInfoItem(
                        it.remoteCoinInfo.id.orEmpty(),
                        it.remoteCoinInfo.name.orEmpty(),
                        it.remoteCoinInfo.fullName.orEmpty(),
                        it.remoteCoinInfo.imageUrl.orEmpty()
                    ),
                    raw = RawItem(
                        usd = UsdItem(
                            it.remoteRaw.usd.price ?: 0.0,
                            it.remoteRaw.usd.changePctDay ?: 0F
                        )
                    )
                )
            }
        }

        fun map(item: String): List<CryptoFeedItem>{
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
            val typeData = Types.newParameterizedType(
                List::class.java,
                CryptoFeedMap::class.java
            )

            val json: JsonAdapter<List<CryptoFeedMap>> = moshi.adapter(typeData)
            val data = json.fromJson(item)

            return data?.map {
                CryptoFeedItem(
                    coinInfo = CoinInfoItem(
                        it.coinInfo.id.orEmpty(),
                        it.coinInfo.name.orEmpty(),
                        it.coinInfo.fullName.orEmpty(),
                        it.coinInfo.imageUrl.orEmpty()
                    ),
                    raw = RawItem(
                        usd = UsdItem(
                            it.raw.usd.price ?: 0.0,
                            it.raw.usd.changePctDay ?: 0F
                        )
                    )
                )
            } ?: emptyList()
        }

        fun mapListToJsonString(obj: List<Any>): String{
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
            val json = moshi.adapter(List::class.java)
           return json.toJson(obj).toString()
        }
    }
}