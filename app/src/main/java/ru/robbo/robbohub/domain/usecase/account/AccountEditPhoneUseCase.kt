package ru.robbo.robbohub.domain.usecase.account

import ru.robbo.robbohub.domain.model.UserEntity
import ru.robbo.robbohub.domain.repository.AccountRepository
import javax.inject.Inject

class AccountEditPhoneUseCase @Inject constructor(
    private val accountRepository: AccountRepository,
    private val userEntity: UserEntity
) {

    suspend operator fun invoke(phone: String) {
        accountRepository.editUserNameById(userEntity.id,phone)
        userEntity.phone = phone
    }
}