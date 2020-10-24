package mz.co.bilheteira.afghangirl.data.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

@Module
@InstallIn(ApplicationComponent::class)
object AfghanGirlServiceBuilder {
    // URL to the Unsplash API
    private const val AFGHAN_GIRL_URL = "https://api.unsplash.com/"

    @Provides
    fun provideLogInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient.Builder =
        OkHttpClient.Builder().addInterceptor(loggingInterceptor)

    @Provides
    fun provideRetrofitBuilder(client: OkHttpClient.Builder): Retrofit.Builder =
        Retrofit.Builder().baseUrl(AFGHAN_GIRL_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())

    @Provides
    fun provideRetrofit(builder: Retrofit.Builder): Retrofit = builder.build()
}