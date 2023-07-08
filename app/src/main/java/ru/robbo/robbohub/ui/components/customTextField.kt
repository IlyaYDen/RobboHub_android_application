package ru.robbo.robbohub.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    text : TextFieldValue,
    hint : String,
    onValueChange : (TextFieldValue) -> Unit
) {
    TextField(value = text, onValueChange = onValueChange,
        placeholder = { Text(hint, color = Color(0xFF9C9C9C)) }
    )
}