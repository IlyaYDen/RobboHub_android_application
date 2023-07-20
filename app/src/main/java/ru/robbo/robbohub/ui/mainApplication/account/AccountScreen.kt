package ru.robbo.robbohub.ui.mainApplication.account

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ru.robbo.robbohub.R
import ru.robbo.robbohub.ui.NavigationPath
import ru.robbo.robbohub.ui.components.CustomButton
import ru.robbo.robbohub.ui.mainApplication.MainNavigationPath
import ru.robbo.robbohub.ui.theme.greenMain
import ru.robbo.robbohub.ui.theme.oswaldFamily

@Composable
fun AccountScreen(navController: NavHostController) {


    val vm = hiltViewModel<AccountViewModel>()
    val userEntity = vm.getUserEntity()


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp, end = 18.dp, bottom = 60.dp, start = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {




        val size = LocalConfiguration.current.screenWidthDp - 2*80
        Box(
            Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .width(size.dp)
                        .height(size.dp)
                        .background(
                            color = Color.Black,
                            shape = CircleShape
                        )
                )
            }
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "settings",
                Modifier.clickable {

                    navController.navigate(
                        MainNavigationPath.settings.path)
                }
            )
        }

        Text(text = userEntity.user_name,
            fontFamily = oswaldFamily,
            fontWeight = FontWeight.Bold,
            //fontSize = 24,
            fontStyle = FontStyle.Normal,
            color = greenMain,
            fontSize = 16.sp
        )

        Text(text = userEntity.phone,
            fontFamily = oswaldFamily,
            fontWeight = FontWeight.Bold,
            //fontSize = 24,
            fontStyle = FontStyle.Normal,
            color = Color.Black,
            fontSize = 14.sp
        )
        if(userEntity.city!="-")
            TextBlock(
                stringResource(id = R.string.account_city_text),
                userEntity.city,

            )

        if(userEntity.club!="-")
            Row {


                TextBlock(
                    stringResource(id = R.string.account_club_text),
                    userEntity.club,
                    Modifier.width((LocalConfiguration.current.screenWidthDp/2).dp)
                )

                CustomButton(
                    text = stringResource(id = R.string.account_on_map_text),
                    onClick = { /*TODO*/ },
                    Modifier.padding(horizontal = 8.dp)
                )
            }

        CustomButton(
            text = stringResource(id = R.string.account_open_in_robbo_crm_button),
            onClick = { /*TODO*/ },
            Modifier.padding(horizontal = 8.dp)
        )

        CustomButton(
            text = stringResource(id = R.string.account_goto_course_button),
            onClick = { /*TODO*/ },
            Modifier.padding(horizontal = 8.dp)
        )

        CustomButton(
            text = stringResource(id = R.string.account_my_score_button),
            onClick = { /*TODO*/ },
            Modifier.padding(horizontal = 8.dp)
        )

        CustomButton(
            text = stringResource(id = R.string.account_logout_button),
            onClick = {

                      },
            Modifier.padding(horizontal = 8.dp),
            color = Color.Gray,
            image = painterResource(id = R.drawable.baseline_power_settings_new_24)
        )
    }
}

@Composable
fun TextBlock(
    name: String,
    description: String,
    modifier: Modifier = Modifier.fillMaxWidth()
) {

    Column(
        modifier
    ) {
        Text(
            text = name,
            fontFamily = oswaldFamily,
            fontWeight = FontWeight.Normal,
            //fontSize = 24,
            fontStyle = FontStyle.Normal,
            color = Color.Gray,
            fontSize = 14.sp,
        )
        Text(
            text = description,
            fontFamily = oswaldFamily,
            fontWeight = FontWeight.Normal,
            //fontSize = 24,
            fontStyle = FontStyle.Normal,
            color = Color.Black,
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.height(14.dp))
    }

}
