package ru.robbo.robbohub.ui.registration

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.robbo.robbohub.R
import ru.robbo.robbohub.ui.NavigationPath
import ru.robbo.robbohub.ui.components.CustomTextField
import ru.robbo.robbohub.ui.components.CustomTextFieldValidate


@Composable
fun RegistrationScreen(
    navController: NavController
) {

    val vm = hiltViewModel<RegistrationViewModel>()


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center ,
    ) {
        Spacer(modifier = Modifier.height(300.dp)) //todo add image

        val pattern = remember { Regex("^\\d+\$") }
        var phone by remember { mutableStateOf(TextFieldValue("")) }
        CustomTextFieldValidate(text = phone,
            hint = stringResource(id = R.string.phone),
            onValueChange = {
                if (it.text.isEmpty() || it.text.matches(pattern)) {
                    phone = it
                }},
            limit = 11,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        Spacer(modifier = Modifier.height(5.dp))
        var password by remember { mutableStateOf(TextFieldValue("")) }
        CustomTextField(text = password,
            hint = stringResource(id = R.string.password),
            onValueChange = {password = it}
        )
        Spacer(modifier = Modifier.height(5.dp))
        var passwordRepeat by remember { mutableStateOf(TextFieldValue("")) }
        CustomTextField(text = passwordRepeat,
            hint = stringResource(id = R.string.password_repeat),
            onValueChange = {passwordRepeat = it}
        )
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = {
            if(password.text.equals(passwordRepeat.text) && phone.text.isNotEmpty()){
                vm.registration(phone.text, password.text)

                navController.navigate(
                    NavigationPath.Authorization.path)
            }
        },

            ) {
            Text(text = stringResource(id = R.string.registration_button))
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = stringResource(id = R.string.goto_login_button),
            modifier = Modifier.clickable {

                navController.navigate(
                    NavigationPath.Authorization.path)
            })
    }
}