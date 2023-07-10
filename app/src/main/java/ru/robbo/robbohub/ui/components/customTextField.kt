package ru.robbo.robbohub.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    text : TextFieldValue,
    hint : String,
    onValueChange : (TextFieldValue) -> Unit
) {
    TextField(value = text, onValueChange = onValueChange,
        placeholder = { Text(hint, color = Color(0xFF9C9C9C)) },

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextFieldValidate(
    text : TextFieldValue,
    hint : String,
    onValueChange : (TextFieldValue) -> Unit,
    limit : Int,
    keyboardOptions : KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
) {
    //val errorMessage = "Text input too long"
    //var text by remember { mutableStateOf("") }
    //var isError by rememberSaveable { mutableStateOf(false) }
    val charLimit = limit

    var isError by remember { mutableStateOf(false) }

    fun validate(text: String) {
        isError = text.length > charLimit
    }
    TextField(
        value = text,
        onValueChange = {
            onValueChange(it)
            validate(text.text)
        },
        placeholder = { Text(hint, color = Color(0xFF9C9C9C)) },
        isError = isError,
        supportingText = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "${text.text.length}/$charLimit",
                    color = Color.DarkGray
                )
            },
        trailingIcon = {
            if(isError)
                Icon(imageVector = Icons.Filled.Warning, contentDescription = "error",tint = MaterialTheme.colorScheme.error)
                //Icon(painter = Icons.Filled.Warning, contentDescription = )
        },
        keyboardOptions = keyboardOptions
        )
}