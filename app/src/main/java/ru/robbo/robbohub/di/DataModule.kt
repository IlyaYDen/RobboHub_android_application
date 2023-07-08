package ru.robbo.robbohub.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.robbo.robbohub.data.database.dataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun providePasswordDb(app: Application): dataBase {
        return synchronized(this) {

            val dbBuilder = Room.databaseBuilder(
                app,//	yury.v.denisov@gmail.com
                dataBase::class.java,
                dataBase.DATABASE_NAME
            )
                .build()
            dbBuilder
        }
    }
}