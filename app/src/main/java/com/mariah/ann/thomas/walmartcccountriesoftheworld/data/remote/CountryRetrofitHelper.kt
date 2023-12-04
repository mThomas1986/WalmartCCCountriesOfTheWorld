package com.mariah.ann.thomas.walmartcccountriesoftheworld.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CountryRetrofitHelper {
    private const val baseUrl = CountryApiDetails.BASE_URL

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(
            OkHttpClient.Builder().addInterceptor(
                HttpLoggingInterceptor().setLevel(
                    HttpLoggingInterceptor.Level.BODY
                )
            ).build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val countryService: CountryApi = retrofit.create(CountryApi::class.java)
}
