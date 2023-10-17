package com.example.h2bet.data.network.models.league

import com.google.gson.annotations.SerializedName

data class GItem(

	@field:SerializedName("O1C")
	val o1C: Int? = null,

	@field:SerializedName("O1")
	val o1: String? = null,

	@field:SerializedName("O1E")
	val o1E: String? = null,

	@field:SerializedName("B")
	val b: Int? = null,

	@field:SerializedName("O2")
	val o2: String? = null,

	@field:SerializedName("DI")
	val dI: String? = null,

	@field:SerializedName("O1I")
	val o1I: Int? = null,

	@field:SerializedName("O1IS")
	val o1IS: List<Int?>? = null,

	@field:SerializedName("I")
	val i: Int? = null,

	@field:SerializedName("O2IS")
	val o2IS: List<Int?>? = null,

	@field:SerializedName("N")
	val n: Int? = null,

	@field:SerializedName("O1IMG")
	val o1IMG: List<String?>? = null,

	@field:SerializedName("SE")
	val sE: String? = null,

	@field:SerializedName("S")
	val s: Int? = null,

	@field:SerializedName("T")
	val t: Int? = null,

	@field:SerializedName("SG")
	val sG: List<SGItem?>? = null,

	@field:SerializedName("SI")
	val sI: Int? = null,

	@field:SerializedName("SIMG")
	val sIMG: String? = null,

	@field:SerializedName("TNS")
	val tNS: String? = null,

	@field:SerializedName("COI")
	val cOI: Int? = null,

	@field:SerializedName("KI")
	val kI: Int? = null,

	@field:SerializedName("O2C")
	val o2C: Int? = null,

	@field:SerializedName("CE")
	val cE: String? = null,

	@field:SerializedName("O2E")
	val o2E: String? = null,

	@field:SerializedName("CI")
	val cI: Int? = null,

	@field:SerializedName("MS")
	val mS: List<Int?>? = null,

	@field:SerializedName("O2I")
	val o2I: Int? = null,

	@field:SerializedName("VE")
	val vE: String? = null,

	@field:SerializedName("O2IMG")
	val o2IMG: List<String?>? = null,

	@field:SerializedName("MIO")
	val mIO: MIO? = null,

	@field:SerializedName("MIS")
	val mIS: List<MISItem?>? = null,

	@field:SerializedName("LE")
	val lE: String? = null,

	@field:SerializedName("TN")
	val tN: String? = null,

	@field:SerializedName("LI")
	val lI: Int? = null,

	@field:SerializedName("PN")
	val pN: String? = null,

	@field:SerializedName("HL")
	val hL: Boolean? = null,

	@field:SerializedName("STI")
	val sTI: String? = null,

	@field:SerializedName("O2CT")
	val o2CT: String? = null,

	@field:SerializedName("O1CT")
	val o1CT: String? = null,

	@field:SerializedName("HSI")
	val hSI: Boolean? = null,

	@field:SerializedName("SS")
	val sS: Int? = null,

	@field:SerializedName("SGI")
	val sGI: String? = null,

	@field:SerializedName("SST")
	val sST: Int? = null,

	@field:SerializedName("GVE")
	val gVE: Int? = null,

	@field:SerializedName("GSE")
	val gSE: Boolean? = null
)