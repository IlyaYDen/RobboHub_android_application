package ru.robbo.robbohub.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.robbo.robbohub.data.model.NewsEntityDbModel
import ru.robbo.robbohub.data.model.UserEntityDbModel

@Database(
    entities = [UserEntityDbModel::class, NewsEntityDbModel::class],
    version = 1,
    exportSchema = true
)
abstract class DataBase : RoomDatabase() {
    abstract val authorizationDao: AuthorizationDao

    companion object {
        const val DATABASE_NAME = "records_db"
    }
}