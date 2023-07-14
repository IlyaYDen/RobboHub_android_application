package ru.robbo.robbohub.ui.mainApplication.newsList.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.robbo.robbohub.R
import ru.robbo.robbohub.ui.components.CustomTextField
import ru.robbo.robbohub.ui.components.CustomTextFieldWithName
import ru.robbo.robbohub.ui.theme.oswaldFamily


@Preview
@Composable
fun NewComponentPreview(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(6.dp)
        //.background(color = Color.White)
    ) {
        Column() {
            NewsComponent()
            NewsComponent()
        }
    }
}
@Composable
fun NewsComponent(
    newsName: String = "МИССИЯ РОББО",

) {
    Surface(
        shape = RoundedCornerShape(7.dp),
        shadowElevation = 8.dp,
        color = Color.White,
        modifier = Modifier.padding(vertical = 5.dp)
        )
    {
        Column(
            ) {

            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = "img",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(3 / 2f)
                    .clip(RoundedCornerShape(7.dp)),
                //contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(vertical = 13.dp, horizontal = 19.dp)
            ) {


                Text(text = newsName,
                    fontFamily = oswaldFamily,
                    fontWeight = FontWeight.Bold,
                    //fontSize = 24,
                    fontStyle = FontStyle.Normal,
                    color = Color(66, 66, 66),
                    fontSize = 20.sp,
                    modifier = Modifier.clickable {
                        // navController.navigate(
                        //     NavigationPath.Registration.path)
                    })
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = stringResource(id = R.string.see_details),
                    fontFamily = oswaldFamily,
                    fontWeight = FontWeight.Bold,
                    //fontSize = 24,
                    fontStyle = FontStyle.Normal,
                    color = Color(0, 164, 0),
                    fontSize = 14.sp,
                    modifier = Modifier.clickable {
                        // navController.navigate(
                        //     NavigationPath.Registration.path)
                    }
                        .padding(16.dp)
                )
            }
        }
    }
}