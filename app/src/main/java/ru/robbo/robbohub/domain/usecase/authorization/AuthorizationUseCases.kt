package ru.robbo.robbohub.domain.usecase.authorization

import javax.inject.Inject

data class AuthorizationUseCases @Inject constructor(
    val registrationUseCase: RegisrationUseCase
)