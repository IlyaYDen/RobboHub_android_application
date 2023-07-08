package ru.robbo.robbohub.data.repository

import ru.robbo.robbohub.data.database.AuthorizationDao
import ru.robbo.robbohub.data.model.UserEntityMapper
import ru.robbo.robbohub.domain.model.UserEntity
import ru.robbo.robbohub.domain.repository.AuthorizationRepository
import javax.inject.Inject

class AuthorizationRepositoryImpl @Inject constructor(
    private val authorizationDao: AuthorizationDao
) : AuthorizationRepository {

    override suspend fun registrationCall(userEntity: UserEntity) {
        authorizationDao.registrationUser(UserEntityMapper().mapEntityToDbModel(userEntity))
    }

    override suspend fun authorizationCall(userEntity: UserEntity) {
        authorizationDao.registrationUser(UserEntityMapper().mapEntityToDbModel(userEntity))
    }

    override suspend fun accountRecoveryCall() {
        TODO("Not yet implemented")
    }
}