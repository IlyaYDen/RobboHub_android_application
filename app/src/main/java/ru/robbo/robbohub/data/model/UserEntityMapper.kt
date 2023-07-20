package ru.robbo.robbohub.data.model

import ru.robbo.robbohub.domain.model.UserEntity
import java.util.UUID

class UserEntityMapper {
    fun mapEntityToDbModel(userEntity: UserEntity) : UserEntityDbModel{
        return UserEntityDbModel(
            id = userEntity.id,
            password = userEntity.password,
            user_name = userEntity.user_name,
            phone = userEntity.phone,
            city = userEntity.city,
            club = userEntity.club,
            score = userEntity.score
        )
    }
    fun mapDbModelToEntity(userEntityDbModel: UserEntityDbModel) : UserEntity {
        return UserEntity(
            id = userEntityDbModel.id,
            password = userEntityDbModel.password,
            user_name = userEntityDbModel.user_name,
            phone = userEntityDbModel.phone,
            city = userEntityDbModel.city,
            club = userEntityDbModel.club,
            score = userEntityDbModel.score
        )
    }
    fun mapListDbModelToListEntity(list: List<UserEntityDbModel>) : List<UserEntity>{
        return list.map { mapDbModelToEntity(it) }
    }
}