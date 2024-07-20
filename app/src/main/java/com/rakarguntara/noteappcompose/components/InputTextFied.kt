package com.rakarguntara.noteappcompose.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.rakarguntara.noteappcompose.R


@Composable
fun InputTextFied(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        modifier = modifier,
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.colors(
            colorResource(R.color.black),
            unfocusedContainerColor = Color.LightGray,
            focusedContainerColor = Color.Transparent,
            unfocusedLabelColor = Color.Black,
            focusedLabelColor = Color.Black,
            focusedIndicatorColor = Color.Red,
            unfocusedIndicatorColor = Color.Transparent
        ),
        maxLines = maxLine,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        })

    )

}

@Preview
@Composable
private fun InputTextFieldPreview(){
    InputTextFied(text = "test", label = "email", onTextChange = {})
}