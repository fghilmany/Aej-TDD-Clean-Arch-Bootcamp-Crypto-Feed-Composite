package com.hightech.cryptoapp.crypto.feed.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crypto_feed")
data class LocalRootCryptoFeed(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "Data")
    val data: String
)

data class LocalCryptoFeed(
    val data: List<LocalCryptoFeedItem>
)

data class LocalCryptoFeedItem(
    val remoteCoinInfo: LocalCoinInfo,
    val remoteRaw: LocalDisplay
)

data class LocalCoinInfo(
    val id: String?,
    val name: String?,
    val fullName: String?,
    val imageUrl: String?,
)

data class LocalDisplay(
    val usd: LocalUsd
)

data class LocalUsd(
    val price: Double?,
    val changePctDay: Float?
)