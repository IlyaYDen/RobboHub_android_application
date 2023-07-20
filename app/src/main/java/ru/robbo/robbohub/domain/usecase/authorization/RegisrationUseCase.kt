package ru.robbo.robbohub.domain.usecase.authorization

import ru.robbo.robbohub.domain.model.UserEntity
import ru.robbo.robbohub.domain.repository.AuthorizationRepository
import ru.robbo.robbohub.ui.authorization.authorization.LoginMode
import java.lang.StringBuilder
import java.math.BigInteger
import java.security.MessageDigest
import java.security.SecureRandom
import java.util.UUID
import javax.inject.Inject

class RegisrationUseCase @Inject constructor(
    private val repository : AuthorizationRepository
)
{
    suspend operator fun invoke(phone: String, password: String): String {


        val md = MessageDigest.getInstance("SHA-256")
        val passwordSha = BigInteger(1, md.digest((StringBuilder(password).append(phone).toString()).toByteArray())).toString(16).padStart(32, '0')


        return repository.registrationCall(phone,passwordSha, UUID.randomUUID().toString())
        //repository.registrationCall(UserEntity(UUID.randomUUID().toString(),phone,passwordSha))
    }

    fun generateNonce(): ByteArray {
        val random = SecureRandom()
        val nonce = ByteArray(16)
        random.nextBytes(nonce)
        return nonce
    }
}