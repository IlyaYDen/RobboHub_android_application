package ru.robbo.robbohub.ui.mainApplication.newsList

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.robbo.robbohub.ui.mainApplication.newsList.components.NewsComponent

@Composable
fun NewsListScreen(
    vm : NewsListViewModel,
    navController : NavController
){
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Log.d("test","trest1")
//        val navController = rememberNavController()


        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            //.background(color = Color.White)
        ) {
            LazyColumn(
                Modifier.fillMaxSize()
            ) {
                // Add a single item
                item {
                    //Text(text = "First item")
                }

                // Add 5 items
                items(vm.newsList.size) { index ->
                    NewsComponent(
                        vm.newsList[index],
                        navController
                    )
                }
            }
        }
        //Text(text = "Home screen")
    }
}