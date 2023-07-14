package ru.robbo.robbohub.data.model

import ru.robbo.robbohub.domain.model.NewsEntity
import ru.robbo.robbohub.domain.model.UserEntity
import java.util.UUID

class NewsEntityMapper {
    fun mapEntityToDbModel(newsEntity: NewsEntity) : NewsEntityDbModel{
        return NewsEntityDbModel(
            id = newsEntity.id,
            text = newsEntity.text,
            name = newsEntity.name,
            description = newsEntity.description,
            image = newsEntity.image
        )
    }
    fun mapDbModelToEntity(userEntityDbModel: NewsEntityDbModel) : NewsEntity {
        return NewsEntity(
            id = userEntityDbModel.id,
            text = userEntityDbModel.text,
            name = userEntityDbModel.name,
            description = userEntityDbModel.description,
            image = userEntityDbModel.image
        )
    }
    fun mapListDbModelToListEntity(list: List<NewsEntityDbModel>) : List<NewsEntity>{
        return list.map { mapDbModelToEntity(it) }
    }
}