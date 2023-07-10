package ru.robbo.robbohub.ui.mainApplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.robbo.robbohub.ui.mainApplication.account.AccountScreen
import ru.robbo.robbohub.ui.mainApplication.links.LinksScreen
import ru.robbo.robbohub.ui.mainApplication.newsList.NewsListScreen

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "news") {
        composable("news"){
            NewsListScreen()
        }
        composable("links"){
            LinksScreen()
        }
        composable("account"){
            AccountScreen()
        }
    }
}