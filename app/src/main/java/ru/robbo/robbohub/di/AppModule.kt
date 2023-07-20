package ru.robbo.robbohub.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.robbo.robbohub.data.database.AccountDao
import ru.robbo.robbohub.data.database.AuthorizationDao
import ru.robbo.robbohub.data.database.NewsDao
import ru.robbo.robbohub.data.repository.AccountRepositoryImpl
import ru.robbo.robbohub.data.repository.AuthorizationRepositoryImpl
import ru.robbo.robbohub.data.repository.NewsRepositoryImpl
import ru.robbo.robbohub.domain.repository.AccountRepository
import ru.robbo.robbohub.domain.repository.AuthorizationRepository
import ru.robbo.robbohub.domain.repository.NewsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAuthorizationRepository(authorizationDao: AuthorizationDao): AuthorizationRepository {
        return AuthorizationRepositoryImpl(authorizationDao)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsDao: NewsDao): NewsRepository {
        return NewsRepositoryImpl(newsDao)
    }

    @Provides
    @Singleton
    fun provideAccountsRepository(accountDao: AccountDao): AccountRepository {
        return AccountRepositoryImpl(accountDao)
    }
}