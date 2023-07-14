package ru.robbo.robbohub.ui.mainApplication.newsList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.robbo.robbohub.ui.mainApplication.newsList.components.NewsComponent

@Composable
fun NewsListScreen(){
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            //.background(color = Color.White)
        ) {
            Column() {
                NewsComponent()
            }
        }
        //Text(text = "Home screen")
    }
}