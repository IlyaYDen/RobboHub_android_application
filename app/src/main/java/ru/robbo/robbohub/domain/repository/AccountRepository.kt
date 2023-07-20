package ru.robbo.robbohub.domain.repository

import ru.robbo.robbohub.domain.model.NewsEntity
import ru.robbo.robbohub.domain.model.UserEntity

interface AccountRepository {

    suspend fun editUserNameById(id: String, userName: String)
    suspend fun editPhoneById(id: String, userName: String)
    suspend fun editUriById(id: String, uri: String)
    suspend fun editCityById(id: String, city: String)
}