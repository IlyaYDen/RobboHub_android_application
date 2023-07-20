package ru.robbo.robbohub.ui.mainApplication.account

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.robbo.robbohub.domain.model.UserEntity
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val userEntity: UserEntity
): ViewModel() {

    fun getUserEntity(): UserEntity{
        return userEntity
    }
}