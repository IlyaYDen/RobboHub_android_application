package ru.robbo.robbohub.domain.usecase.news

import ru.robbo.robbohub.domain.model.NewsEntity
import ru.robbo.robbohub.domain.repository.NewsRepository
import java.util.UUID
import javax.inject.Inject

class InsertNewUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(
        name: String,
        description: String,
        text: String,
        //todo image: String,

    ) {
        repository.insertNews(NewsEntity(UUID.randomUUID().toString(),name,description,text,"img"))
    }
}