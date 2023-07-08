package ru.robbo.robbohub.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.robbo.robbohub.data.repository.AuthorizationRepositoryImpl
import ru.robbo.robbohub.domain.repository.AuthorizationRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAuthorizationRepository(): AuthorizationRepository {
        return AuthorizationRepositoryImpl()
    }
}