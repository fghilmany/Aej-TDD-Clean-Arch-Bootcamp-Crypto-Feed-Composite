package com.example.http

import com.squareup.moshi.Json

data class Raw(

	@Json(name="usd")
	val usd: Usd
)

data class CoinInfo(

	@Json(name="imageUrl")
	val imageUrl: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="fullName")
	val fullName: String? = null,

	@Json(name="id")
	val id: String? = null
)

data class CryptoFeedMap(

	@Json(name="raw")
	val raw: Raw,

	@Json(name="coinInfo")
	val coinInfo: CoinInfo
)

data class Usd(

	@Json(name="price")
	val price: Double? = null,

	@Json(name="changePctDay")
	val changePctDay: Float? = null
)
