package ru.robbo.robbohub.ui.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.robbo.robbohub.R
import ru.robbo.robbohub.ui.NavigationPath

@Composable
fun StartScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center ,
    ) {
        Spacer(modifier = Modifier.height(300.dp)) //todo add image
        Button(onClick = {
            navController.navigate(
                NavigationPath.Authorization.path)

        },

            ) {
            Text(text = stringResource(id = R.string.login_button))
        }
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = {
            navController.navigate(
                NavigationPath.Registration.path)
        },

            ) {
            Text(text = stringResource(id = R.string.registration_button))
        }
    }
}