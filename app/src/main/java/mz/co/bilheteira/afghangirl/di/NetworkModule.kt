package mz.co.bilheteira.afghangirl.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import mz.co.bilheteira.afghangirl.data.remote.AfghanGirlService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideAfghanGirlService(retrofit: Retrofit): AfghanGirlService =
        retrofit.create(AfghanGirlService::class.java)
}