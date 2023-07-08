package ru.robbo.robbohub.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class UserEntityDbModel(
    @PrimaryKey val id : UUID,
    val phone: String,
    val password: String,
    val permissions: Byte = 0
)