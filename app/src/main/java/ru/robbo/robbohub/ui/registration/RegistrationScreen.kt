package ru.robbo.robbohub.ui.registration

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.robbo.robbohub.R
import ru.robbo.robbohub.ui.NavigationPath
import ru.robbo.robbohub.ui.components.CustomButtonFilled
import ru.robbo.robbohub.ui.components.CustomTextField
import ru.robbo.robbohub.ui.components.CustomTextFieldValidate
import ru.robbo.robbohub.ui.components.CustomTextFieldWithName
import ru.robbo.robbohub.ui.theme.greenMain
import ru.robbo.robbohub.ui.theme.oswaldFamily


@Composable
fun RegistrationScreen(
    navController: NavController
) {

    val vm = hiltViewModel<RegistrationViewModel>()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 55.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top ,
    ) {
        Text(
            text = stringResource(R.string.register_page_main_text),
            fontFamily = oswaldFamily,
            fontWeight = FontWeight.Bold,
            //fontSize = 24,
            fontStyle = FontStyle.Normal,
            color = Color.Black,
            fontSize = 24.sp

        )
        Spacer(modifier = Modifier.height(45.dp))

        val pattern = remember { Regex("^\\d+\$") }
        val phone = remember { mutableStateOf<String>("") }
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


        val password = remember { mutableStateOf<String>("") }
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
        Spacer(modifier = Modifier.height(20.dp))


        val passwordRepeat = remember { mutableStateOf<String>("") }
        CustomTextFieldWithName(
            value = passwordRepeat,
            hint = "Enter Password",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = {
                passwordRepeat.value = it
            },
            textFieldName = stringResource(R.string.password_repeat),
            visualTransformation = PasswordVisualTransformation()
        )
//todo passwordRepeat
        Spacer(modifier = Modifier.height(45.dp))

        CustomButtonFilled(
            text = stringResource(id = R.string.registration_button),
            onClick = {

                if(password.value.equals(passwordRepeat.value) && phone.value.isNotEmpty()){
                    vm.registration(phone.value, password.value)
//
                    navController.navigate(
                        NavigationPath.Authorization.path)
                }
                      },
            colors = ButtonDefaults.buttonColors(containerColor = greenMain),
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom ,
        ) {

            Text(text = stringResource(id = R.string.already_have_account),
                fontFamily = oswaldFamily,
                fontWeight = FontWeight.Bold,
                //fontSize = 24,
                fontStyle = FontStyle.Normal,
                color = Color(153, 153, 153),
                fontSize = 14.sp,
                modifier = Modifier.clickable {
                        navController.navigate(
                            NavigationPath.Authorization.path)
                })
        }
    }
}