package com.example.h2bet.data.network.models.league

import com.google.gson.annotations.SerializedName

data class SGItem(

	@field:SerializedName("SS")
	val sS: Int? = null,

	@field:SerializedName("TG")
	val tG: String? = null,

	@field:SerializedName("T")
	val t: Int? = null,

	@field:SerializedName("TI")
	val tI: Int? = null,

	@field:SerializedName("CI")
	val cI: Int? = null,

	@field:SerializedName("SI")
	val sI: Int? = null,

	@field:SerializedName("GVE")
	val gVE: Int? = null,

	@field:SerializedName("I")
	val i: Int? = null,

	@field:SerializedName("MG")
	val mG: Int? = null,

	@field:SerializedName("EC")
	val eC: Int? = null,

	@field:SerializedName("N")
	val n: Int? = null,

	@field:SerializedName("PN")
	val pN: String? = null,

	@field:SerializedName("P")
	val p: Int? = null,

	@field:SerializedName("DI")
	val dI: String? = null
)