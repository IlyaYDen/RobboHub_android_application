package ru.robbo.robbohub.ui.authorization

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.robbo.robbohub.R
import ru.robbo.robbohub.ui.NavigationPath
import ru.robbo.robbohub.ui.components.CustomTextField
import ru.robbo.robbohub.ui.registration.RegistrationViewModel


@SuppressLint("SuspiciousIndentation")
@Composable
fun AuthorizationScreen(
    navController: NavController
) {

    val vm = hiltViewModel<AuthorizationViewModel>()



    val authStatus = remember { vm.getAuthorizationStatus() }
    LaunchedEffect(authStatus) {
        authStatus.collect {
            loginMode ->
            if(loginMode == LoginMode.ONLINE)
            navController.navigate(
                NavigationPath.Start.path)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center ,
    ) {
        Spacer(modifier = Modifier.height(300.dp)) //todo add image

        var phone by remember { mutableStateOf(TextFieldValue("")) }
        CustomTextField(text = phone,
            hint = stringResource(id = R.string.phone),
            onValueChange = {phone = it}
        )

        Spacer(modifier = Modifier.height(5.dp))
        var password by remember { mutableStateOf(TextFieldValue("")) }
        CustomTextField(text = password,
            hint = stringResource(id = R.string.password),
            onValueChange = {password = it}
        )
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = {
            //navController.navigate(
            //    NavigationPath.Authorization.path)
            vm.authorization(phone = phone.text, password = password.text)

        },

            ) {
            Text(text = stringResource(id = R.string.login_button))
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = stringResource(id = R.string.goto_registration_button),
        modifier = Modifier.clickable {

            navController.navigate(
                NavigationPath.Registration.path)
        })
    }
}