package ru.robbo.robbohub.ui.mainApplication.newInfo

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.robbo.robbohub.R
import ru.robbo.robbohub.domain.model.NewsEntity
import ru.robbo.robbohub.ui.theme.oswaldFamily

@Composable
@Preview
fun NewScreenPreview() {
    NewScreen(NewsEntity("test","test","test","test","test",))
}

@Composable
fun NewScreen(
    newsEntity: NewsEntity
) {
    Box(
        modifier = Modifier.padding(5.dp)
    ) {


        LazyColumn(
            Modifier.fillMaxSize()
        ) {
            item {
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


                            Text(text = newsEntity.name,
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
                            Text(text = newsEntity.text,
                                fontFamily = oswaldFamily,
                                fontWeight = FontWeight.Normal,
                                //fontSize = 24,
                                fontStyle = FontStyle.Normal,
                                color = Color(0, 0, 0),
                                fontSize = 14.sp,
                                modifier = Modifier.clickable {
                                }
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}