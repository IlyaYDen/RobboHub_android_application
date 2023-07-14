package ru.robbo.robbohub.ui.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.robbo.robbohub.R
import ru.robbo.robbohub.ui.NavigationPath
import ru.robbo.robbohub.ui.components.CustomButton
import ru.robbo.robbohub.ui.components.CustomButtonFilled
import ru.robbo.robbohub.ui.theme.greenMain
import ru.robbo.robbohub.ui.theme.oswaldFamily

@Composable
//@Preview
fun StartScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(38.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(3f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {
            Spacer(modifier = Modifier.weight(.5f))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                Modifier
                    //.scale(1.4f)
                    .padding(15.dp)
                    .fillMaxSize()
                    .weight(1f)

            )

            Text(text = stringResource(id = R.string.simply_interesting_freedom),
                fontFamily = oswaldFamily,
                fontWeight = FontWeight.Bold,
                //fontSize = 24,
                fontStyle = FontStyle.Normal,
                color = Color(153, 153, 153),
                fontSize = 14.sp,
                modifier = Modifier.clickable {
                    //navController.navigate(
                    //    NavigationPath.Authorization.path
                    //)
                }
                   // .weight(4f)
            )
        }
        Column(
            modifier = Modifier
                .weight(4f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {
            CustomButtonFilled(
                text = stringResource(id = R.string.registration_button),
                onClick = {

                    navController.navigate(
                        NavigationPath.Registration.path
                    )
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                textColor = Color.Black
            )
            Spacer(modifier = Modifier.height(5.dp))

            CustomButton(
                text = stringResource(id = R.string.log_in_button),
                onClick = {
                      navController.navigate(
                          NavigationPath.Authorization.path
                      )
                },
                color = greenMain,
            )
        }
    }
}