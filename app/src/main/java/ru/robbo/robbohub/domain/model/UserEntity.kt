package ru.robbo.robbohub.domain.model

import java.util.UUID

data class UserEntity(
    val id : String,
    val phone: String,
    val password: String,
    val permissions: Byte = 0
)