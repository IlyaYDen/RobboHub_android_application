package ru.robbo.robbohub.ui.authorization.authorization

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.robbo.robbohub.R
import ru.robbo.robbohub.ui.NavigationPath
import ru.robbo.robbohub.ui.components.CustomButtonFilled
import ru.robbo.robbohub.ui.components.CustomTextFieldWithName
import ru.robbo.robbohub.ui.theme.oswaldFamily


@SuppressLint("SuspiciousIndentation")
//@Preview
@Composable
fun AuthorizationScreen(
    navController: NavController
) {

    val vm = hiltViewModel<AuthorizationViewModel>()



    val authStatus = remember { vm.authorizationStatus }
    LaunchedEffect(authStatus) {
        authStatus.collect {
            loginMode ->
            if(loginMode == LoginMode.ONLINE)
            navController.navigate(
                NavigationPath.MainApplication.path)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 55.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top ,
    ) {
        Text(
            text = stringResource(R.string.auth_page_main_text),
            fontFamily = oswaldFamily,
            fontWeight = FontWeight.Bold,
            //fontSize = 24,
            fontStyle = FontStyle.Normal,
            color = Color.Black,
            fontSize = 24.sp

        )

        Spacer(modifier = Modifier.height(45.dp))

        val pattern = remember { Regex("^\\d+\$") }
        val phone = remember { mutableStateOf<String>("1") }
        CustomTextFieldWithName(
            value = phone,
            hint = stringResource(R.string.enter_phone_number),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = {
                if (it.isEmpty() || it.matches(pattern)) {
                    phone.value = it
                }},
            textFieldName = stringResource(R.string.phone)

        )
        Spacer(modifier = Modifier.height(20.dp))

        val password = remember { mutableStateOf<String>("1") }
        CustomTextFieldWithName(
            value = password,
            hint = "Enter Password",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = {
                password.value = it
            },
            textFieldName = stringResource(R.string.password),
            visualTransformation = PasswordVisualTransformation()

        )

        Spacer(modifier = Modifier.height(45.dp))

        CustomButtonFilled(
            text = stringResource(id = R.string.login_button),
            onClick = {
                //navController.navigate(
                //    NavigationPath.Authorization.path)
                vm.authorization(phone = phone.value, password = password.value)
                      },
            colors = ButtonDefaults.buttonColors(containerColor = Color(31, 215, 6)),
        )
        //Button(onClick = {
        //    //navController.navigate(
        //    //    NavigationPath.Authorization.path)
        //    //vm.authorization(phone = phone.value, password = password.value)
//
        //},
//
        //    ) {
        //    Text(text = stringResource(id = R.string.login_button))
        //}

        Spacer(modifier = Modifier.height(25.dp))

        Text(text = stringResource(id = R.string.forgot_password),
            fontFamily = oswaldFamily,
            fontWeight = FontWeight.Bold,
            //fontSize = 24,
            fontStyle = FontStyle.Normal,
            color = Color(153, 153, 153),
            fontSize = 14.sp,
            modifier = Modifier.clickable {
                // navController.navigate(
                //     NavigationPath.Registration.path)
            })
        Spacer(modifier = Modifier.height(203.dp))
            Text(text = stringResource(id = R.string.goto_registration_button),
                fontFamily = oswaldFamily,
                fontWeight = FontWeight.Bold,
                //fontSize = 24,
                fontStyle = FontStyle.Normal,
                color = Color(153, 153, 153),
                fontSize = 14.sp,
                modifier = Modifier.clickable {
                    navController.navigate(
                        NavigationPath.Registration.path
                    )
                })
    }
}