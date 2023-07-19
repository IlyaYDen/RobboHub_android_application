package ru.robbo.robbohub.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.robbo.robbohub.data.model.NewsEntityDbModel

@Dao
interface NewsDao {

    @Query("SELECT * FROM NewsEntityDbModel")
    fun getNews() : List<NewsEntityDbModel>

    @Insert
    fun insertNew(newsEntityDbModel: NewsEntityDbModel)
}
