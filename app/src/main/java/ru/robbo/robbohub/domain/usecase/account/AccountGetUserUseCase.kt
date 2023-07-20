package ru.robbo.robbohub.domain.usecase.account

import ru.robbo.robbohub.domain.model.UserEntity
import ru.robbo.robbohub.domain.repository.AccountRepository
import javax.inject.Inject

class AccountGetUserUseCase @Inject constructor(
    private val userEntity: UserEntity
) {

     operator fun invoke() : UserEntity {
        return userEntity
    }
}