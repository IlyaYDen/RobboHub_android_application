package ru.robbo.robbohub.data.model

import ru.robbo.robbohub.domain.model.UserEntity
import java.util.UUID

class UserEntityMapper {
    fun mapEntityToDbModel(userEntity: UserEntity) : UserEntityDbModel{
        return UserEntityDbModel(
            id = userEntity.id,
            password = userEntity.password,
            permissions = userEntity.permissions,
            phone = userEntity.phone
        )
    }
    fun mapDbModelToEntity(userEntityDbModel: UserEntityDbModel) : UserEntity {
        return UserEntity(
            id = userEntityDbModel.id,
            password = userEntityDbModel.password,
            permissions = userEntityDbModel.permissions,
            phone = userEntityDbModel.phone
        )
    }
    fun mapListDbModelToListEntity(list: List<UserEntityDbModel>) : List<UserEntity>{
        return list.map { mapDbModelToEntity(it) }
    }
}