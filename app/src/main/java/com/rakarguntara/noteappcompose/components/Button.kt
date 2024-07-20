package com.rakarguntara.noteappcompose.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.rakarguntara.noteappcompose.R

@Composable
fun ButtonCustom(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
    enabled: Boolean = true
) {
    Button(onClick = onClick,
        shape = CircleShape,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.navy),
            contentColor = colorResource(R.color.grey)
        )
        ){
        Text(text)
    }
}

@Preview
@Composable
private fun ButtonPreview(){
    ButtonCustom(modifier = Modifier, "Submit", onClick = {})
}