package ru.robbo.robbohub.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.robbo.robbohub.data.model.UserEntityDbModel
import java.util.concurrent.Flow

@Dao
interface AuthorizationDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun registrationUser(userEntityDbModel: UserEntityDbModel)

    @Query("SELECT COUNT(*) FROM UserEntityDbModel")
    fun getUsersCount(): Int
    //@Query("SELECT COUNT(1)\n" +
    //        "FROM UserEntityDbModel\n" +
    //        "WHERE password = userEntityDbModel.password & " +
    //        "phone = userEntityDbModel.phone;")
    @Query("SELECT * FROM UserEntityDbModel")
    fun getUsers() : List<UserEntityDbModel>
}
