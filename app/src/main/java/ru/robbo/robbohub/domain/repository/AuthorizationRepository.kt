package ru.robbo.robbohub.domain.repository

import ru.robbo.robbohub.domain.model.UserEntity

interface AuthorizationRepository {
    suspend fun registrationCall(userEntity: UserEntity)
    suspend fun authorizationCall(userEntity: UserEntity)
    suspend fun accountRecoveryCall()

}