package com.mariah.ann.thomas.walmartcccountriesoftheworld.data.remote

import com.mariah.ann.thomas.walmartcccountriesoftheworld.data.model.CountryModel
import retrofit2.Response
import retrofit2.http.GET

interface CountryApi {
    @GET(CountryApiDetails.COUNTRIES_ENDPOINT)
    suspend fun getCountries() : Response<ArrayList<CountryModel>>
}
