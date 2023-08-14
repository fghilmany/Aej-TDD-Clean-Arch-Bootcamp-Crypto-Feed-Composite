package com.hightech.cryptoapp.crypto.feed.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CryptoFeedDao {
    @Query("Select * From crypto_feed")
    fun load(): Flow<LocalRootCryptoFeed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: LocalRootCryptoFeed)
}