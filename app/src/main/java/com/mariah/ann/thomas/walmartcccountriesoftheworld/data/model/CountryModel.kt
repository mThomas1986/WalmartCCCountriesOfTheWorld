package com.mariah.ann.thomas.walmartcccountriesoftheworld.data.model

import com.google.gson.annotations.SerializedName

data class CountryModel(
    @SerializedName("capital")
    val capital: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("currency")
    val currencyModel: CurrencyModel,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("language")
    val languageModel: LanguageModel,
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String
)

data class CurrencyModel(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String
)

data class LanguageModel(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
)
