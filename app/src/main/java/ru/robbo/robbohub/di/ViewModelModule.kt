package ru.robbo.robbohub.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class ViewModelModule {

    //@Provides
    //@Singleton
    //fun provideRegistrationViewModel(registrationUseCases: AuthorizationUseCases): RegistrationViewModel {
    //    return RegistrationViewModel(registrationUseCases)
    //}
}