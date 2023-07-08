package ru.robbo.robbohub.data.database

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import ru.robbo.robbohub.data.model.UserEntityDbModel

@Database (
    entities = [UserEntityDbModel::class],
    version = 1,
    exportSchema = true
)
abstract class dataBase : RoomDatabase() {
    abstract val authorizationDao : AuthorizationDao
    //abstract val userDao : UserDao
    //abstract val recordAddFieldDao : RecordAddFieldDao
    //abstract val noteDao : NoteDao

    companion object {
        const val DATABASE_NAME = "records_db"
    }
}
