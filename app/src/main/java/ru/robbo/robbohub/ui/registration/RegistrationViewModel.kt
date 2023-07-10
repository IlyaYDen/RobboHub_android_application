package ru.robbo.robbohub.ui.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.robbo.robbohub.domain.usecase.authorization.AuthorizationUseCases
import javax.inject.Inject
import javax.inject.Scope


@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val authUseCases: AuthorizationUseCases
): ViewModel() {

    fun registration(phone: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            authUseCases.registrationUseCase.invoke(phone,password)
        }
    }

}
