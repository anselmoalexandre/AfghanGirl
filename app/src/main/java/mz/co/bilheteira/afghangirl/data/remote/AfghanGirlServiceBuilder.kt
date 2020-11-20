package mz.co.bilheteira.afghangirl.data.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AfghanGirlServiceBuilder {
    // URL to the Unsplash API
    private const val AFGHAN_GIRL_URL = "https://api.unsplash.com/"

    @Singleton
    @Provides
    fun provideLogInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient.Builder =
        OkHttpClient.Builder().addInterceptor(loggingInterceptor)

    @Singleton
    @Provides
    fun provideRetrofitBuilder(client: OkHttpClient.Builder): Retrofit.Builder =
        Retrofit.Builder().baseUrl(AFGHAN_GIRL_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())

    @Singleton
    @Provides
    fun provideRetrofit(builder: Retrofit.Builder): Retrofit = builder.build()
}