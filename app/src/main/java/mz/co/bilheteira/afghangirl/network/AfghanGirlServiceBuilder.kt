package mz.co.bilheteira.afghangirl.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AfghanGirlServiceBuilder {
    // URL to the Unsplash API
    private const val AFGHAN_GIRL_URL = "https://api.unsplash.com/"

    // Logging Interceptor
    private val logInterceptor: HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    // OkHttp Client
    private val okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(
        logInterceptor
    )

    // Retrofit builder
    private val builder: Retrofit.Builder = Retrofit.Builder().baseUrl(AFGHAN_GIRL_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient.build())

    // Retrofit instance
    private val retrofit: Retrofit = builder.build()

    /**
     * Use this method to build your retrofit builder
     * [T] Generic type
     */
    fun <T> buildService(type: Class<T>): T = retrofit.create(type)
}