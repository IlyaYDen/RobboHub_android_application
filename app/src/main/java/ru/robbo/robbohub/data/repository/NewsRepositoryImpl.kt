package ru.robbo.robbohub.data.repository

import android.util.Log
import ru.robbo.robbohub.data.database.AuthorizationDao
import ru.robbo.robbohub.data.database.NewsDao
import ru.robbo.robbohub.data.model.NewsEntityMapper
import ru.robbo.robbohub.data.model.UserEntityMapper
import ru.robbo.robbohub.domain.model.NewsEntity
import ru.robbo.robbohub.domain.model.UserEntity
import ru.robbo.robbohub.domain.repository.AuthorizationRepository
import ru.robbo.robbohub.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsDao: NewsDao
) : NewsRepository {

    override suspend fun insertNews(newsEntity: NewsEntity) {
        newsDao.insertNew(NewsEntityMapper().mapEntityToDbModel(newsEntity))
    }

    override suspend fun getNews(): List<NewsEntity> {
        return NewsEntityMapper().mapListDbModelToListEntity(newsDao.getNews())
    }

}