package ru.robbo.robbohub.domain.usecase.news

import ru.robbo.robbohub.domain.model.NewsEntity
import ru.robbo.robbohub.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsListUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(): List<NewsEntity> {
        return repository.getNews()
    }
}