package ru.robbo.robbohub.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.robbo.robbohub.data.model.UserEntityDbModel
import java.util.concurrent.Flow

@Dao
interface AuthorizationDao {

    @Insert
    fun registrationUser(userEntityDbModel: UserEntityDbModel)

    //@Query("SELECT COUNT(1)\n" +
    //        "FROM UserEntityDbModel\n" +
    //        "WHERE password = userEntityDbModel.password & " +
    //        "phone = userEntityDbModel.phone;")
    @Query("SELECT * FROM UserEntityDbModel")
    fun getUsers() : List<UserEntityDbModel>
}
