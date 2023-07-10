package ru.robbo.robbohub.ui.mainApplication

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import ru.robbo.robbohub.ui.components.bottomNavigation.BottomNavItem
import ru.robbo.robbohub.ui.components.bottomNavigation.BottomNavigationBar


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ApplicationScreen() {
    val navController2 = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items =listOf(
                    BottomNavItem(name = "news",
                        route = "news",
                        Icons.Default.Home
                    ),
                    BottomNavItem(name = "Links",
                        route = "links",
                        Icons.Default.Info
                    ),
                    BottomNavItem(name = "Account",
                        route = "account",
                        Icons.Default.AccountBox
                    )
                ),
                navController =navController2,
                onItemClick = {
                    navController2.navigate(it.route)
                }
            )
        }
    ) {
        MainNavigation(navController = navController2)
    }
}