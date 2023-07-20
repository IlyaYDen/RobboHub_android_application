package ru.robbo.robbohub

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import ru.robbo.robbohub.ui.NavigationPath
import ru.robbo.robbohub.ui.authorization.authorization.AuthorizationScreen
import ru.robbo.robbohub.ui.mainApplication.ApplicationScreen
import ru.robbo.robbohub.ui.authorization.accountInitialization.AccountInitializationScreen
import ru.robbo.robbohub.ui.authorization.registration.RegistrationScreen
import ru.robbo.robbohub.ui.authorization.start.StartScreen
import ru.robbo.robbohub.ui.theme.RobboHubTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RobboHubTheme {

                Navigation(this)
            }
        }
    }
    @Composable
    fun  Navigation(context: Context) {

        val navController = rememberNavController()
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.linearGradient(
                        0f to Color(0x02202327),
                        1f to Color(0x0226292d),
                        start = Offset.Zero,
                        end = Offset.Infinite,
                        tileMode = TileMode.Clamp
                    )
                )
                //.drawWithCache {
                //    onDrawWithContent {
                //        //val b = ShaderBrush()
                //    }
                //}

                .fillMaxSize()
        )
        NavHost(navController = navController, startDestination = NavigationPath.Start.path) {

            composable(
                route = NavigationPath.Start.path
            ) {

                BackHandler(true) {
                    // todo
                }
                StartScreen(
                    navController
                )
            }
            composable(
                route = NavigationPath.Authorization.path
            ) {

                BackHandler(true) {
                    // todo
                }
                AuthorizationScreen(
                    navController
                )
            }
            composable(
                route = NavigationPath.Initialization.path + "?id={id}",
                arguments = listOf(
                    navArgument("id") {type = NavType.StringType}
                )
            ) {

                BackHandler(true) {
                    // todo
                }
                it.arguments?.getString("id")?.let { it1 ->
                    AccountInitializationScreen(
                        navController, it1
                    )
                }
            }
            composable(
                route = NavigationPath.Registration.path
            ) {

                BackHandler(true) {
                    // todo
                }
                RegistrationScreen(
                    navController

                )
            }
            composable(
                route = NavigationPath.MainApplication.path
            ) {

                BackHandler(true) {
                    // todo
                }
                ApplicationScreen()
            }
        }
    }
}
