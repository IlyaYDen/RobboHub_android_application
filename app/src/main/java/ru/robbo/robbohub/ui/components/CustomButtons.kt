package ru.robbo.robbohub.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.robbo.robbohub.ui.theme.greenMain
import ru.robbo.robbohub.ui.theme.oswaldFamily

@Preview
@Composable
fun CustomButtonFilledPreview() {
    Column {
        CustomButton(
            text = "test",
            onClick = {}
        )
        CustomButtonFilled(
            onClick = {},
            text = "test"
        )
    }
}

@Composable
fun CustomButtonFilled(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    border: BorderStroke? = null,
    content: @Composable RowScope.() -> Unit
) {

    Button(
        onClick = onClick,
        modifier.fillMaxWidth(),
        shape = RoundedCornerShape(7.dp),
        enabled = enabled,
        colors = colors,
        border = border,
        content = content
    )
}
@Composable
fun CustomButtonFilled(
    text : String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    border: BorderStroke? = null,
    textColor: Color = Color.White
) {


        Button(
            onClick = onClick,
            modifier.fillMaxWidth(),
            shape = RoundedCornerShape(7.dp),
            enabled = enabled,
            colors = colors,
            border = border,
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp)
        )
        {
            Text(
                text = text,
                color = textColor,
                fontFamily = oswaldFamily
            )
        }
}
@Composable
fun BottomShadow(alpha: Float = 0.1f, height: Dp = 8.dp,modifier : Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxWidth()
        .height(height)
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color.Black.copy(alpha = alpha),
                    Color.Transparent,
                )
            )
        )
    )
}



@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    color: Color = greenMain,
    image: Painter? = null
) {

    Button(
        onClick = onClick,
        modifier.fillMaxWidth(),
        shape = RoundedCornerShape(7.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,

        ),
        border = BorderStroke(1.dp, color)
    ) {
        if(image!=null){
            Image(
                painter = image,
                contentDescription = "image",
                colorFilter = ColorFilter.tint(
                    color = color
                ),
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }
        Text(
            text = text,
            color = color,
            fontFamily = oswaldFamily
        )
    }
}

@Preview
@Composable
fun ShadowButton(
) {
    Box(modifier = Modifier.wrapContentSize()) {
        Spacer(
            modifier = Modifier
                .offset(x = 0.dp, y = 3.dp)
                .shadow(
                    elevation = 20.dp,
                    shape = ButtonDefaults.filledTonalShape, clip = false,
                    ambientColor = Color.Black, spotColor = Color.Black
                ),
        )
        Button(modifier = Modifier, onClick = {}) {
            Text(text = "test")
        }
    }
}