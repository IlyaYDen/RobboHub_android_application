package ru.robbo.robbohub.domain.usecase.account

import ru.robbo.robbohub.domain.model.UserEntity
import ru.robbo.robbohub.domain.repository.AccountRepository
import javax.inject.Inject

class AccountEditCityUseCase @Inject constructor(
    private val accountRepository: AccountRepository,
    private val userEntity: UserEntity
) {

    suspend operator fun invoke(city: String) {
        accountRepository.editCityById(userEntity.id,city)
        userEntity.city = city
    }
}