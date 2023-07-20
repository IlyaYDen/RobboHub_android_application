package ru.robbo.robbohub.ui.authorization.accountInitialization

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.robbo.robbohub.domain.model.UserEntity
import ru.robbo.robbohub.domain.repository.AccountRepository
import ru.robbo.robbohub.domain.usecase.account.AccountEditUserNameUseCase
import ru.robbo.robbohub.domain.usecase.account.AccountUseCases
import javax.inject.Inject

@HiltViewModel
class AccountInitializationViewModel @Inject constructor(
    private val accountUseCases: AccountUseCases
):ViewModel() {
    fun addUserInfo(account_id: String, value: String, image: Uri) {
        viewModelScope.launch(Dispatchers.IO) {
            //accountRepository.editUriById(account_id,image.)
        }
    }

    fun addUserInfo(account_id: String, value: String) {
        viewModelScope.launch(Dispatchers.IO) {
            accountUseCases.accountEditUserNameUseCase.invoke(value)


        }
    }
}