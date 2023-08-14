package com.hightech.cryptoapp.frameworks

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.hightech.cryptoapp.crypto.feed.local.CryptoFeedDatabase

object LocalFactory {
    lateinit var application: Application

    fun createDatabase() = Room.databaseBuilder(
        application.applicationContext,
        CryptoFeedDatabase::class.java,
        "crypto"
    ).build()
}