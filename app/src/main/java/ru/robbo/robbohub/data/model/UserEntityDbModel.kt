package ru.robbo.robbohub.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["phone"],unique = true)])
data class UserEntityDbModel(
    @PrimaryKey val id : String,
    val phone: String,
    val password: String,
    val user_name: String,
    val city: String = "-",
    val club: String= "-",
    val score: Int = 0
)