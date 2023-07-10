package ru.robbo.robbohub.data.repository

import android.util.Log
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

    override suspend fun authorizationCall(userEntity: UserEntity) : Int{

        authorizationDao.getUsers().forEach {
            if(userEntity.phone == it.phone && userEntity.password == it.password)
                return 1
        }

        return 0//authorizationDao.authorizationUser(UserEntityMapper().mapEntityToDbModel(userEntity))
    }

    override suspend fun accountRecoveryCall() {
        TODO("Not yet implemented")
    }
}