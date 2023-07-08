package ru.robbo.robbohub.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.robbo.robbohub.data.repository.AuthorizationRepositoryImpl
import ru.robbo.robbohub.domain.repository.AuthorizationRepository
import ru.robbo.robbohub.domain.usecase.authorization.AuthorizationUseCases
import ru.robbo.robbohub.ui.registration.RegistrationViewModel
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ViewModelModule {

    @Provides
    @Singleton
    fun provideRegistrationViewModel(registrationUseCases: AuthorizationUseCases): RegistrationViewModel {
        return RegistrationViewModel(registrationUseCases)
    }
}