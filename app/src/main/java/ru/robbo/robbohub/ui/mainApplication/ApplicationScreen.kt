package ru.robbo.robbohub.ui.mainApplication

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import ru.robbo.robbohub.ui.components.bottomNavigation.BottomNavItem
import ru.robbo.robbohub.ui.components.bottomNavigation.BottomNavigationBar
import ru.robbo.robbohub.ui.theme.oswaldFamily


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ApplicationScreen() {
    val navController2 = rememberNavController()
    Scaffold(
        topBar = {
            Column(

            ) {

                TopAppBar(
                    title = {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                            Text(
                                text = "Подробно",

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

                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Back"
                                )
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = "Back"
                                )
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
        },
        bottomBar = {
            Column() {

                Box(
                    Modifier
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Black.copy(alpha = 0f),
                                    Color.Black.copy(alpha = 0.2f)
                                ),
                            )
                        )
                        .fillMaxWidth()
                        .height(8.dp)
                )

                BottomNavigationBar(
                    items = listOf(
                        BottomNavItem(
                            name = "news",
                            route = "news",
                            Icons.Default.Home
                        ),
                        BottomNavItem(
                            name = "Links",
                            route = "links",
                            Icons.Default.Info
                        ),
                        BottomNavItem(
                            name = "Account",
                            route = "account",
                            Icons.Default.AccountBox
                        )
                    ),
                    navController = navController2,
                    onItemClick = {
                        navController2.navigate(it.route)
                    }
                )
            }
        },
    ) {
        MainNavigation(navController = navController2)
    }
}