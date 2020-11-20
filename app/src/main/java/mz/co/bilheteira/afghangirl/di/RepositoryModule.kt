package mz.co.bilheteira.afghangirl.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import mz.co.bilheteira.afghangirl.data.remote.AfghanGirlService
import mz.co.bilheteira.afghangirl.repository.*
import javax.inject.Singleton

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    /**
     * Telling Hilt how to get instances of Afghan Girl Repo
     */
    @Provides
    @Singleton
    @ActivityRetainedScoped
    fun provideAfghanGirlRepository(afghanGirlService: AfghanGirlService): AfghanGirlRepository =
        AfghanGirlRepositoryImpl(afghanGirlService = afghanGirlService)
}