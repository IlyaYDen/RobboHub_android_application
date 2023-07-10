package ru.robbo.robbohub.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.robbo.robbohub.data.database.AuthorizationDao
import ru.robbo.robbohub.data.database.DataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun providePasswordDb(app: Application): DataBase {
        return synchronized(this) {

            val dbBuilder = Room.databaseBuilder(
                app,
                DataBase::class.java,
                DataBase.DATABASE_NAME
            )
                .build()
            dbBuilder
        }
    }

    @Provides
    @Singleton
    fun providePasswordDao(db: DataBase): AuthorizationDao {
        return db.authorizationDao
    }
}