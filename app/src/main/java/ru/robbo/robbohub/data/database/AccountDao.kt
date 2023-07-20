package ru.robbo.robbohub.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.robbo.robbohub.data.model.UserEntityDbModel

@Dao
interface AccountDao {

    @Query(
        "UPDATE UserEntityDbModel set user_name = :userName " +
                "WHERE id = :id"
    )
    fun editUserNameById(id: String, userName: String)

    @Query(
        "UPDATE UserEntityDbModel set phone = :phone " +
                "WHERE id = :id"
    )
    fun editPhoneById(id: String, phone: String)

    @Query(
        "UPDATE UserEntityDbModel set city = :city " +
                "WHERE id = :id"
    )
    fun editCityById(id: String, city: String)

    @Query(
        "UPDATE UserEntityDbModel set club = :club " +
                "WHERE id = :id"
    )
    fun editClubById(id: String, club: String)
    //@Query(
    //    "UPDATE UserEntityDbModel set img = :uri " +
    //            "WHERE id = :id"
    //)
    //fun editUriById(id: String, uri: String)
    //@Insert
    //fun registrationUser(userEntityDbModel: UserEntityDbModel)
}
