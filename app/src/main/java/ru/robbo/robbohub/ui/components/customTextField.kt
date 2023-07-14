package ru.robbo.robbohub.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ru.robbo.robbohub.R
import ru.robbo.robbohub.ui.theme.mainFont
import ru.robbo.robbohub.ui.theme.oswaldFamily

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun CustomTextFieldPreview(){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    CustomTextField(
        text,
        "hint",
        {text = it}
    )
}*/

@Preview
@Composable
fun CustomTextFieldPreview(){
    val text = remember { mutableStateOf<String>("") }
    val warning = "test"
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)) {
        Column() {
            CustomTextField(
                value = text,
                hint = "Enter Password",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                onValueChange = {
                    text.value = it
                },
                //warning = warning
//
            )
            CustomTextFieldWithName(
                value = text,
                hint = "Enter Password",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                onValueChange = {
                    text.value = it
                },
                textFieldName = stringResource(R.string.auth_page_main_text)

            )
        }
    }
}

val hintAlpha = 0.4f
@Composable
fun CustomTextFieldWithName(
    textFieldName : String,
    modifier: Modifier = Modifier,
    value: State<String>,
    hint: String = "",
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    enabled: Boolean = true,
    imageResource: ImageVector? = null,
    warning: State<String> = remember { mutableStateOf("") },
    visualTransformation : VisualTransformation = VisualTransformation.None,

    enteredTextStyle: TextStyle = TextStyle(
        fontSize = mainFont.bodyMedium.fontSize,
        fontWeight = FontWeight.Light,
        fontFamily = oswaldFamily,
        color = Color.Black,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Left,
    ),
    hintTextStyle: TextStyle = TextStyle(
        fontSize = mainFont.bodyMedium.fontSize,
        fontWeight = FontWeight.Light,
        fontFamily = oswaldFamily,
        color = Color.Black,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Left,
    )){

    Column() {

        Text(
            text = textFieldName,
            fontFamily = oswaldFamily,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            color = Color.Black,
            fontSize = mainFont.bodyMedium.fontSize

        )
        Spacer(modifier = Modifier.height(10.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)) {
            CustomTextField(
                value = value,
                hint = hint,
                keyboardOptions = keyboardOptions,
                onValueChange = onValueChange,
                modifier = modifier,
                enabled= enabled,
                imageResource = imageResource,
                warning = warning,
                visualTransformation = visualTransformation,
                enteredTextStyle = enteredTextStyle,
                hintTextStyle = hintTextStyle
            )
        }
    }
}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    //BasicTexModifier : Modifier = Modifier,
    value: State<String>,
    hint: String = "",
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    //interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    enabled: Boolean = true,
    imageResource: ImageVector? = null,
    warning: State<String> = remember { mutableStateOf("") },
    visualTransformation : VisualTransformation = VisualTransformation.None,

    enteredTextStyle: TextStyle = TextStyle(
        fontSize = mainFont.bodyMedium.fontSize,
        fontWeight = FontWeight.Light,
        fontFamily = oswaldFamily,
        color = Color.Black,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Left,
    ),
    hintTextStyle: TextStyle = TextStyle(
        fontSize = mainFont.bodyMedium.fontSize,
        fontWeight = FontWeight.Light,
        fontFamily = oswaldFamily,
        color = Color.Black,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Left,
    )
) {
    val isFocusedState = remember { mutableStateOf(false) }
    val isWarningClicked = remember { mutableStateOf(false) }

    val warningBorder by animateFloatAsState(
        if(warning.value=="") 0f else 0.6f
    )
    val selectedBorder by animateFloatAsState(
        if(!isFocusedState.value) 0f else 0.6f
    )
    onValueChange.also {
        isWarningClicked.value = false
    }
    var t = TextStyle(
        fontSize = mainFont.bodyMedium.fontSize,
        fontWeight = enteredTextStyle.fontWeight,
        fontFamily = oswaldFamily,
        color = enteredTextStyle.color.copy(alpha = 0.7f),
        fontStyle = FontStyle.Italic,
        textAlign = enteredTextStyle.textAlign
    )
    Box(modifier = modifier
        .fillMaxWidth()) {
        BasicTextField(
            textStyle = if(visualTransformation == PasswordVisualTransformation()) t else enteredTextStyle,
            visualTransformation = visualTransformation,
            value = value.value,
            onValueChange = onValueChange,
            keyboardOptions = keyboardOptions,
            singleLine = true,
            enabled = enabled,
            cursorBrush = Brush.verticalGradient(colors = listOf(Color(0xFF000000), Color(0xFF000000))),
            //cursorBrush = SolidColor(colors.cursorColor(isError).value),


            modifier = modifier
                .fillMaxWidth()
                .onFocusChanged {
                    isFocusedState.value = it.isFocused
                    if (it.isFocused) {
                        isWarningClicked.value = false
                    }
                },

            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color(0x0).copy(alpha = 0.03f),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .border(
                            //if(warning.value.isEmpty())
                            BorderStroke(
                                1.dp,
                                color = Color.Black.copy(alpha = hintAlpha)
                            ),
                            RoundedCornerShape(6.dp)
                        )

                        .padding(vertical = 6.dp, horizontal = 4.dp), // inner padding
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    if(imageResource!=null)
                        Icon(
                            imageVector = imageResource,
                            contentDescription = "Favorite icon",
                            tint = Color.DarkGray
                        )
                    Spacer(modifier = Modifier.width(width = 4.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        if (value.value.isEmpty()) {
                            Text(
                                text = hint,
                                fontSize = 16.sp,//mainFont.bodyMedium.fontSize,
                                fontWeight = FontWeight.Normal,
                                fontFamily = oswaldFamily,
                                fontStyle = FontStyle.Normal,
                                color = Color.Black.copy(alpha = hintAlpha),
                                //textAlign = textAlign,
                                style = hintTextStyle,
                                modifier = Modifier.fillMaxWidth()
                            )
                        } else
                            Text(
                                text = " ",
                                fontSize = 16.sp,//mainFont.bodyMedium.fontSize,
                                fontWeight = FontWeight.Normal,
                                fontFamily = oswaldFamily,
                                fontStyle = FontStyle.Normal,
                                color = Color.Black.copy(alpha = hintAlpha),
                                //textAlign = textAlign,
                                style = hintTextStyle,
                                modifier = Modifier.fillMaxWidth()
                            )
                        val align = enteredTextStyle.textAlign

                        var t : Arrangement.Horizontal = Arrangement.Start
                        if(align!=null) {
                            if (align.equals(TextAlign.Center)) {
                                t = Arrangement.Center
                            } else if (align.equals(TextAlign.Right)) {
                                t = Arrangement.End
                            }else if (align.equals(TextAlign.Left)) {
                                t = Arrangement.Start
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = t
                        ) {
                            innerTextField()
                        }
                    }
                }
            }
        )

        if(warningBorder!=0f) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 2.dp)
                ,
                horizontalArrangement = Arrangement.End
            ) {
                //CustomWarningField(
                //    166*warningBorder,
                //    warningText = warning.value,
                //    isWarningClicked = isWarningClicked
                //)
            }
        }
    }
}
/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: TextFieldValue,
    hint : String,
    onValueChange : (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = TextFieldDefaults.filledShape,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors()
) {
    // If color is not provided via the text style, use content color as a default
    val textColor = Color.Black
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))

    //CompositionLocalProvider(LocalTextSelectionColors provides colors.selectionColors) {
    //    @OptIn(ExperimentalMaterial3Api::class)
        BasicTextField(
        value = value,
        modifier = modifier
            .defaultMinSize(
                minWidth = TextFieldDefaults.MinWidth,
                minHeight = TextFieldDefaults.MinHeight
            ),
        onValueChange = onValueChange,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = mergedTextStyle,
        cursorBrush = SolidColor(Color.Black),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        interactionSource = interactionSource,
        singleLine = singleLine,
        maxLines = maxLines,
        decorationBox = @Composable { innerTextField ->
            // places leading icon, text field with label and placeholder, trailing icon
            TextFieldDefaults.TextFieldDecorationBox(
                value = value.text,
                visualTransformation = visualTransformation,
                innerTextField = innerTextField,
                placeholder = placeholder,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                supportingText = supportingText,
                shape = RoundedCornerShape(7.dp),
                singleLine = singleLine,
                enabled = enabled,
                isError = isError,
                interactionSource = interactionSource,
                colors = colors
            )
        })
    //))
    //}
}*/
/*
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
 */

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