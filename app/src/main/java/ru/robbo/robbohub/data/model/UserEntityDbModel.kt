package ru.robbo.robbohub.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntityDbModel(
    @PrimaryKey val id : String,
    val phone: String,
    val password: String,
    val permissions: Byte = 0
)