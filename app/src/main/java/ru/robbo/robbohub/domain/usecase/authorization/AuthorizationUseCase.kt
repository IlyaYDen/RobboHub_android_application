package ru.robbo.robbohub.domain.usecase.authorization

import ru.robbo.robbohub.data.model.UserEntityDbModel
import ru.robbo.robbohub.domain.model.UserEntity
import ru.robbo.robbohub.domain.repository.AuthorizationRepository
import java.lang.StringBuilder
import java.math.BigInteger
import java.security.MessageDigest
import java.security.SecureRandom
import java.util.UUID
import javax.inject.Inject

class AuthorizationUseCase @Inject constructor(
    private val repository : AuthorizationRepository,
    private val userEntity : UserEntity
)
{
    suspend operator fun invoke(phone: String, password: String): Int {
        val md = MessageDigest.getInstance("SHA-256")
        val passwordSha = BigInteger(1, md.digest((StringBuilder(password).append(phone).toString()).toByteArray())).toString(16).padStart(32, '0')

        val user = repository.authorizationCall(phone,passwordSha)
        if(user!=null)
            userEntity.setAll(user)
        return if(user != null) 1 else 0
    }
}