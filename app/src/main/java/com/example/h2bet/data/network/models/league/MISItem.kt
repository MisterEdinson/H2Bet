package com.example.h2bet.data.network.models.league

import com.google.gson.annotations.SerializedName

data class MISItem(

	@field:SerializedName("V")
	val v: String? = null,

	@field:SerializedName("K")
	val k: Int? = null
)