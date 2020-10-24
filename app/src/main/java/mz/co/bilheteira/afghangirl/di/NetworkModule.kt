package mz.co.bilheteira.afghangirl.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import mz.co.bilheteira.afghangirl.data.remote.AfghanGirlService
import retrofit2.Retrofit

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    fun provideAfghanGirlService(retrofit: Retrofit): AfghanGirlService =
        retrofit.create(AfghanGirlService::class.java)
}