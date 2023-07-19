package ru.robbo.robbohub.ui.mainApplication

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.robbo.robbohub.ui.mainApplication.account.AccountScreen
import ru.robbo.robbohub.ui.mainApplication.links.LinksScreen
import ru.robbo.robbohub.ui.mainApplication.newInfo.NewScreen
import ru.robbo.robbohub.ui.mainApplication.newsList.NewsListScreen
import ru.robbo.robbohub.ui.mainApplication.newsList.NewsListViewModel

@Composable
fun MainNavigation(navController: NavHostController) {

    val vm = hiltViewModel<NewsListViewModel>()
    NavHost(navController = navController, startDestination = MainNavigationPath.news.path) {
        composable(MainNavigationPath.news.path){


            LaunchedEffect(navController.currentBackStackEntry) {
                vm.getNews()
            }
            NewsListScreen(vm, navController)
        }
        composable(
            MainNavigationPath.newsInfo.path + "?new_id={new_id}",
            arguments = listOf(
                navArgument("new_id") {type = NavType.StringType}
            )
        ){ backStackEntry ->
          //  vm.getNews()
            val item = vm.newsList.find { it.id == backStackEntry.arguments?.getString("new_id") }
            item?.let { NewScreen(it) }

        }
        composable("links"){
            LinksScreen()
        }
        composable("account"){
            AccountScreen()
        }
    }
}
sealed class MainNavigationPath(val path: String){

    object news : MainNavigationPath(path = "news")
    object newsInfo : MainNavigationPath(path = "news_info")

    fun withArgs(vararg args: Pair<String,String>) =
        buildString {
            append(path)
            args.forEach { arg ->
                append("?${arg.first}=${arg.second}")
            }
        }
}