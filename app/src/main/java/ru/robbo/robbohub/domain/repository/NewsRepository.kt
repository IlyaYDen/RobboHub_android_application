package ru.robbo.robbohub.domain.repository

import ru.robbo.robbohub.domain.model.NewsEntity
import ru.robbo.robbohub.domain.model.UserEntity

interface NewsRepository {
    suspend fun insertNews(newsEntity: NewsEntity)
    suspend fun getNews() : List<NewsEntity>

}