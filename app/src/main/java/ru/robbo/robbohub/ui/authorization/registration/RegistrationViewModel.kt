package ru.robbo.robbohub.ui.authorization.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.robbo.robbohub.domain.model.UserEntity
import ru.robbo.robbohub.domain.usecase.authorization.AuthorizationUseCases
import ru.robbo.robbohub.ui.authorization.authorization.LoginMode
import javax.inject.Inject


@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val authUseCases: AuthorizationUseCases,
    private val userEntity: UserEntity
): ViewModel() {

    private val authorizationStatus = MutableStateFlow("-1")
    fun registration(phone: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = authUseCases.registrationUseCase.invoke(phone,password)
            if(result != "-1") {
                authorizationStatus.value = result
                userEntity.phone = phone
            }
        }
    }

    fun getRegisterStatus(): MutableStateFlow<String> {
        return authorizationStatus
    }


}
