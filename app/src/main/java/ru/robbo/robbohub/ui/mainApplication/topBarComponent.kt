package ru.robbo.robbohub.ui.mainApplication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.robbo.robbohub.ui.theme.oswaldFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBarComponent(
    actionBarText: MutableState<Int>,
    navController2: NavHostController,

    ) {
    Column(

        modifier = Modifier.height(65.dp),
    ) {

        TopAppBar(
            title = {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        Modifier.clickable {
                            navController2.popBackStack()
                        },
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    //val item = mainNavigationPathItems.find { it.path.equals(navController2.currentDestination) }
                    Text(
                        text =  stringResource(id = actionBarText.value),

                        fontFamily = oswaldFamily,
                        fontWeight = FontWeight.Normal,
                        //fontSize = 24,
                        fontStyle = FontStyle.Normal,
                        color = Color.White,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center

                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        //Icon(
                        //    imageVector = Icons.Default.ArrowBack,
                        //    contentDescription = "Back"
                        //)
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Back",
                            tint = Color.White
                        )

                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Green
            )
        )
        Box(
            Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.2f),
                            Color.Black.copy(alpha = 0f)
                        ),
                    )
                )
                .fillMaxWidth()
                .height(8.dp)
        )
    }
}