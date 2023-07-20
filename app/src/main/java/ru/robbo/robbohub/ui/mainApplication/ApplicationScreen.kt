package ru.robbo.robbohub.ui.mainApplication

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import ru.robbo.robbohub.R
import ru.robbo.robbohub.ui.components.bottomNavigation.BottomNavItem
import ru.robbo.robbohub.ui.components.bottomNavigation.BottomNavigationBar


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ApplicationScreen() {
    val navController2 = rememberNavController()

    val actionBarText = remember { mutableStateOf(R.string.news_screen_name) }


    Scaffold(
        topBar = {
            topBarComponent(
                actionBarText,navController2
            )
        },
        bottomBar = {
            Column(

                modifier = Modifier.height(65.dp),
            ) {

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
                            topBarStringId = R.string.news_screen_name,
                            Icons.Default.Home
                        ),
                        BottomNavItem(
                            name = "Links",
                            route = "links",
                            topBarStringId = R.string.links_screen_name,
                            Icons.Default.Info
                        ),
                        BottomNavItem(
                            name = "Account",
                            route = "account",
                            topBarStringId = R.string.account_screen_name,
                            Icons.Default.AccountBox
                        )
                    ),
                    navController = navController2,
                    onItemClick = {

                        navController2.navigate(it.route)
                        actionBarText.value = it.topBarStringId
                    }
                )
            }
        },
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(top = 58.dp, bottom = 58.dp)) {
            MainNavigation(navController = navController2)
            Log.d("test2","trgre")
        }
    }
}