package ru.robbo.robbohub.domain.repository

import ru.robbo.robbohub.data.model.UserEntityDbModel
import ru.robbo.robbohub.domain.model.UserEntity

interface AuthorizationRepository {
    suspend fun registrationCall(phone: String, password:String, userName:String): String
    suspend fun authorizationCall(phone: String, password:String) : UserEntity?
    suspend fun accountRecoveryCall()

}