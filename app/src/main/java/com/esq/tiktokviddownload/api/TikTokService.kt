package com.esq.tiktokviddownload.api

import com.esq.tiktokviddownload.model.TikTokResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface TikTokService {

    @GET("")
    suspend fun getTikTokObject(
        @Header("Authorization") token: String,
        @Query("url") url: String
    ): TikTokResponse

    companion object {
        private val logInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        private val httpClient = OkHttpClient.Builder().apply {
            callTimeout(1, TimeUnit.MINUTES)
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(15, TimeUnit.SECONDS)
            addInterceptor(logInterceptor)
        }
        private var retrofit: Retrofit? = null

        val client: TikTokService
            get() {
                when (retrofit) {//Build retrofit using the API's base URL
                    null -> retrofit = Retrofit.Builder()
                        .client(httpClient.build())
                        .addConverterFactory(MoshiConverterFactory.create())
                        .baseUrl("http://tiktok2.p.rapidapi.com/")
                        .build()
                }
                //Creating object for our interface
                return retrofit!!.create(TikTokService::class.java) // return the API Interface object
            }
    }
}