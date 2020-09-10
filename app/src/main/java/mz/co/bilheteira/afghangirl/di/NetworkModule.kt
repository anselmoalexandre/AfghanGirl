package mz.co.bilheteira.afghangirl.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import mz.co.bilheteira.afghangirl.data.remote.AfghanGirlService
import mz.co.bilheteira.afghangirl.data.remote.AfghanGirlServiceBuilder

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    fun provideAfghanGirlService(): AfghanGirlService {
        return AfghanGirlServiceBuilder.buildService(type = AfghanGirlService::class.java)
    }
}