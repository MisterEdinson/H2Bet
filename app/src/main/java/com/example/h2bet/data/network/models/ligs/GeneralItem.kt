package com.example.h2bet.data.network.models.ligs

import com.google.gson.annotations.SerializedName

data class GeneralItem(

	@field:SerializedName("Value")
	val value: List<ValueItem?>? = null,

	@field:SerializedName("Error")
	val error: String? = null,

	@field:SerializedName("ErrorCode")
	val errorCode: Int? = null,

	@field:SerializedName("Guid")
	val guid: String? = null,

	@field:SerializedName("Id")
	val id: Int? = null,

	@field:SerializedName("Success")
	val success: Boolean? = null
)