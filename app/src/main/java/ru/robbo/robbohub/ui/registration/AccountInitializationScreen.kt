package ru.robbo.robbohub.ui.registration

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.robbo.robbohub.R
import ru.robbo.robbohub.ui.NavigationPath
import ru.robbo.robbohub.ui.components.CustomButtonFilled
import ru.robbo.robbohub.ui.components.CustomTextFieldWithName
import ru.robbo.robbohub.ui.theme.greenMain
import ru.robbo.robbohub.ui.theme.mainFont
import ru.robbo.robbohub.ui.theme.oswaldFamily

@Composable
@Preview
fun AccountInitializationScreenPreview() {
    AccountInitializationScreen()
}@Composable
fun AccountInitializationScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 55.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top ,
    ) {
        Text(
            text = stringResource(R.string.register_init_main_text),
            fontFamily = oswaldFamily,
            fontWeight = FontWeight.Bold,
            //fontSize = 24,
            fontStyle = FontStyle.Normal,
            color = Color.Black,
            fontSize = 24.sp

        )

        val imageUri = remember {
            mutableStateOf<Uri?>(null)
        }
        val context = LocalContext.current
        val bitmap =  remember {
            mutableStateOf<Bitmap?>(null)
        }
        val launcher = rememberLauncherForActivityResult(contract =
        ActivityResultContracts.GetContent()) { uri: Uri? ->
            imageUri.value = uri
        }


        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(R.string.profile_select_image),
            fontFamily = oswaldFamily,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            color = Color.Black,
            fontSize = mainFont.bodyMedium.fontSize,
            modifier = Modifier.fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            launcher.launch("image/*")
        }) {
            Text(text = "Pick image")
        }

        imageUri.value?.let {
            if (Build.VERSION.SDK_INT < 28) {
                bitmap.value = MediaStore.Images
                    .Media.getBitmap(context.contentResolver,it)

            } else {
                val source = ImageDecoder
                    .createSource(context.contentResolver,it)
                bitmap.value = ImageDecoder.decodeBitmap(source)
            }

            bitmap.value?.let {  btm ->
                Image(bitmap = btm.asImageBitmap(),
                    contentDescription =null,
                    modifier = Modifier.size(400.dp))
            }
        }


        val userName = remember { mutableStateOf<String>("") }
        CustomTextFieldWithName(
            value = userName,
            hint = stringResource(R.string.enter_user_name),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = {
                userName.value = it
            },
            textFieldName = stringResource(R.string.user_name)

        )
        Spacer(modifier = Modifier.height(45.dp))

        CustomButtonFilled(
            text = stringResource(id = R.string.continue_),
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(containerColor = greenMain),
        )
    }
}