package ru.robbo.robbohub.ui.mainApplication.accountSettings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ru.robbo.robbohub.R
import ru.robbo.robbohub.ui.NavigationPath
import ru.robbo.robbohub.ui.authorization.registration.RegistrationViewModel
import ru.robbo.robbohub.ui.components.CustomButtonFilled
import ru.robbo.robbohub.ui.components.CustomTextField
import ru.robbo.robbohub.ui.mainApplication.MainNavigationPath
import ru.robbo.robbohub.ui.mainApplication.account.AccountViewModel
import ru.robbo.robbohub.ui.theme.oswaldFamily

@Composable
@Preview
fun AccountSettingsScreenPre() {

    //AccountSettingsScreen(navController)
}
@Composable
fun AccountSettingsScreen(navController: NavHostController) {


    val vm = hiltViewModel<AccountSettingsViewModel>()
    val user = vm.getUser()


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp, end = 18.dp, bottom = 60.dp, start = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color.Black)
        )
        val name = remember { mutableStateOf<String>(user.user_name) }
        EditButton(
            Icons.Default.Person,
            "Person",
            name
        )
        Box(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color.Black.copy(alpha = 0.2f))
        )



        val phone = remember { mutableStateOf<String>(user.phone) }
        EditButton(
            Icons.Default.Phone,
            "Phone",
            phone
        )
        Box(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color.Black.copy(alpha = 0.2f))
        )


        val city = remember { mutableStateOf<String>(user.city) }
        EditButton(
            Icons.Default.Person,
            "",
            city
        )
        Box(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color.Black.copy(alpha = 0.2f))
        )
        CustomButtonFilled(
            onClick = {
                vm.setUserUserName(name.value)
                vm.setUserPhone(phone.value)
                vm.setUserCity(city.value)
            }
        ) {

            Text(text = stringResource(id = R.string.save_settings),
                fontFamily = oswaldFamily,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                color = Color(153, 153, 153),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun EditButton(
    image : ImageVector,
    imageDescription : String,
    text : MutableState<String>
) {
    Column(
        Modifier
            .padding(vertical = 8.dp)
    ) {
        Row(
            Modifier.fillMaxWidth()

        ) {

            Row(Modifier.weight(2f)) {
                Icon(imageVector = image, contentDescription = imageDescription)
                Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                CustomTextField(
                    value = text,
                    onValueChange = {
                        text.value = it
                    },
                    hint = stringResource(id = R.string.settings_user_name)
                )
            }

            Row(
                Modifier.weight(1f),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = imageDescription)
            }
        }
    }
}
