package ru.robbo.robbohub.domain.usecase.account

import javax.inject.Inject

data class AccountUseCases @Inject constructor(
    val accountEditUserNameUseCase: AccountEditUserNameUseCase,
    val accountEditCityUseCase: AccountEditCityUseCase,
    val accountEditPhoneUseCase: AccountEditPhoneUseCase,
    val accountGetUserUseCase: AccountGetUserUseCase
)