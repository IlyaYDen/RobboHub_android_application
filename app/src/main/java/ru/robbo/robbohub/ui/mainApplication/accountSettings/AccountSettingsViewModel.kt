package ru.robbo.robbohub.ui.mainApplication.accountSettings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.robbo.robbohub.domain.model.UserEntity
import ru.robbo.robbohub.domain.usecase.account.AccountUseCases
import javax.inject.Inject

@HiltViewModel
class AccountSettingsViewModel @Inject constructor(
    private val accountUseCases: AccountUseCases
) : ViewModel() {



    fun getUser(): UserEntity{

        return accountUseCases.accountGetUserUseCase.invoke()
    }

    fun setUserCity(value: String) {
        viewModelScope.launch(Dispatchers.IO) {
            accountUseCases.accountEditCityUseCase.invoke(value)
        }

    }

    fun setUserUserName(value: String) {

        viewModelScope.launch(Dispatchers.IO) {
            accountUseCases.accountEditUserNameUseCase.invoke(value)
        }
    }
    fun setUserPhone(value: String) {

        viewModelScope.launch(Dispatchers.IO) {
            accountUseCases.accountEditPhoneUseCase.invoke(value)
        }
    }
}
