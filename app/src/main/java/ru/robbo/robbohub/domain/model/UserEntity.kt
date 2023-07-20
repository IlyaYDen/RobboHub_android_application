package ru.robbo.robbohub.domain.model

import java.util.UUID

data class UserEntity(
    var id : String,
    var phone: String,
    var password: String,
    var user_name: String,
    var city: String = "-",
    var club: String = "-",
    var score: Int = 0
) {
    fun setAll(user: UserEntity) {
        this.id = user.id
        this.city = user.city
        this.phone = user.phone
        this.user_name = user.user_name
        this.club = user.club
        this.password = user.password
        this.score = user.score
    }
}