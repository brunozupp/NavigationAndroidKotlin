package com.novelitech.navigationwithretrofitmvvm.features.common.data.services.themealdb

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object TheMealDbRestClient {

    private val jsonConfiguration = Json {
        ignoreUnknownKeys = true
    }

    private val key = "1"

    private val theMealDbService by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/$key/")
            .addConverterFactory(jsonConfiguration.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    val theMealDbRestClient: TheMealDbService by lazy {
        theMealDbService.create(TheMealDbService::class.java)
    }
}