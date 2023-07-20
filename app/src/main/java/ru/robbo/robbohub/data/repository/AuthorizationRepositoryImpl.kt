package ru.robbo.robbohub.data.repository

import android.util.Log
import ru.robbo.robbohub.data.database.AuthorizationDao
import ru.robbo.robbohub.data.model.UserEntityDbModel
import ru.robbo.robbohub.data.model.UserEntityMapper
import ru.robbo.robbohub.domain.model.UserEntity
import ru.robbo.robbohub.domain.repository.AuthorizationRepository
import java.util.UUID
import javax.inject.Inject

class AuthorizationRepositoryImpl @Inject constructor(
    private val authorizationDao: AuthorizationDao
) : AuthorizationRepository {

    override suspend fun registrationCall(
        phone: String,
        password: String,
        userName: String
    ): String {
        val uuid = UUID.randomUUID().toString()

        val count = authorizationDao.getUsersCount() //dummy logic
        authorizationDao.registrationUser(UserEntityDbModel(uuid,phone,password,userName))

        return if(count-authorizationDao.getUsersCount()==0) "-1" else uuid //dummy logic
    }

    override suspend fun authorizationCall(phone: String, password:String) : UserEntity? {

        authorizationDao.getUsers().forEach {
            if(phone == it.phone && password == it.password)
                return UserEntityMapper().mapDbModelToEntity(it)
        }

        return null//authorizationDao.authorizationUser(UserEntityMapper().mapEntityToDbModel(userEntity))
    }

    override suspend fun accountRecoveryCall() {
        TODO("Not yet implemented")
    }
}