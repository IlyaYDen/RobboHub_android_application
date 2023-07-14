package ru.robbo.robbohub.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewsEntityDbModel(
    @PrimaryKey val id : String,
    val name : String,
    val description : String,
    val text : String,
    val image : String
)