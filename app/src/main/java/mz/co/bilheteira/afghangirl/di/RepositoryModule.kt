package mz.co.bilheteira.afghangirl.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import mz.co.bilheteira.afghangirl.data.remote.AfghanGirlService
import mz.co.bilheteira.afghangirl.repository.HomeRepository
import mz.co.bilheteira.afghangirl.repository.HomeRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideAfghanGirlHomeRepository(afghanGirlService: AfghanGirlService): HomeRepository {
        return HomeRepositoryImpl(afghanGirlService = afghanGirlService)
    }
}