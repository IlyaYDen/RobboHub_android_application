package ru.robbo.robbohub.data.repository

import ru.robbo.robbohub.data.database.AccountDao
import ru.robbo.robbohub.domain.model.UserEntity
import ru.robbo.robbohub.domain.repository.AccountRepository
import ru.robbo.robbohub.domain.repository.AuthorizationRepository
import ru.robbo.robbohub.domain.repository.NewsRepository
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val accountDao: AccountDao
) : AccountRepository {

    override suspend fun editUserNameById(id: String, userName: String){
        accountDao.editUserNameById(id,userName)
    }

    override suspend fun editPhoneById(id: String, phone: String) {
        accountDao.editPhoneById(id,phone)
    }
    override suspend fun editCityById(id: String, city: String) {
        accountDao.editCityById(id,city)
    }

    override suspend fun editUriById(id: String, uri: String) {
        //accountDao.editUriById(id,uri)
    }
}