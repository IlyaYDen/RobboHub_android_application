package ru.robbo.robbohub.domain.usecase.account

import ru.robbo.robbohub.domain.model.UserEntity
import ru.robbo.robbohub.domain.repository.AccountRepository
import javax.inject.Inject

class AccountEditUserNameUseCase @Inject constructor(
    private val accountRepository: AccountRepository,
    private val userEntity: UserEntity
) {

    suspend operator fun invoke(userName: String) {
        accountRepository.editUserNameById(userEntity.id,userName)
        userEntity.user_name = userName
    }
}