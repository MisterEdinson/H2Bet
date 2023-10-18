package com.example.h2bet.data.network.models.league

import com.google.gson.annotations.SerializedName

data class Value(

	@field:SerializedName("COIMG")
	val cOIMG: String? = null,

	@field:SerializedName("SE")
	val sE: String? = null,

	@field:SerializedName("T")
	val t: Int? = null,

	@field:SerializedName("CI")
	val cI: Int? = null,

	@field:SerializedName("SI")
	val sI: Int? = null,

	@field:SerializedName("G")
	val g: List<GItem?>? = null,

	@field:SerializedName("LE")
	val lE: String? = null,

	@field:SerializedName("SN")
	val sN: String? = null,

	@field:SerializedName("GC")
	val gC: Int? = null,

	@field:SerializedName("L")
	val l: String? = null,

	@field:SerializedName("LI")
	val lI: Int? = null
)