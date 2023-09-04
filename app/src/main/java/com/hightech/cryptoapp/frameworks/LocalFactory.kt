package com.hightech.cryptoapp.frameworks

import android.app.Application
import androidx.room.Room
import com.example.cache.CryptoFeedDatabase

object LocalFactory {
    lateinit var application: Application

    fun createDatabase() = Room.databaseBuilder(
        application.applicationContext,
        CryptoFeedDatabase::class.java,
        "crypto"
    ).build()
}