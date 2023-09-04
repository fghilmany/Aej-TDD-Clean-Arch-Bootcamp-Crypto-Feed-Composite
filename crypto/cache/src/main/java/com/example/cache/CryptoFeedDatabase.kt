package com.example.cache

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [LocalRootCryptoFeed::class],
    version = 1,
    exportSchema = false
)
abstract class CryptoFeedDatabase: RoomDatabase() {
    abstract fun cryptoFeedDao(): CryptoFeedDao
}