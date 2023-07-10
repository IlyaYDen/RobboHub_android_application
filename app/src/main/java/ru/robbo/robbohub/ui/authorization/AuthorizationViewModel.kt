package ru.robbo.robbohub.ui.authorization

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.robbo.robbohub.domain.usecase.authorization.AuthorizationUseCases
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val authUseCases: AuthorizationUseCases
): ViewModel()  {
    private val authorizationStatus = MutableStateFlow(LoginMode.ERROR)

    fun authorization(phone : String, password : String) {
        viewModelScope.launch(Dispatchers.IO) {
            val authInfo = viewModelScope.async(Dispatchers.IO) {
                authUseCases.authorizationUseCase.invoke(phone, password)
            }
            val authInfoInt = authInfo.await()
            if(authInfoInt == 1) authorizationStatus.value = LoginMode.ONLINE
        }
    }

    fun getAuthorizationStatus() : StateFlow<LoginMode>{
        return authorizationStatus
    }
}