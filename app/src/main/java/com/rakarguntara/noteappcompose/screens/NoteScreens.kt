package com.rakarguntara.noteappcompose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rakarguntara.noteappcompose.R
import com.rakarguntara.noteappcompose.components.ButtonCustom
import com.rakarguntara.noteappcompose.components.InputTextFied
import com.rakarguntara.noteappcompose.models.NotesModel

@SuppressLint("ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreens(
    notes: List<NotesModel>,
    onAddNotesModel: (NotesModel)-> Unit,
    onRemoveNotesModel: (NotesModel)-> Unit,
) {
    val title = remember {
        mutableStateOf("")
    }
    val desc = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
        ,) {
        TopAppBar(
            modifier = Modifier,
            title = {
                Text(stringResource(R.string.app_name), style = TextStyle(
                    color = Color.White
                ))
            },
            actions = {
                Icon(imageVector = Icons.Rounded.Notifications,
                    contentDescription = stringResource(R.string.icon_top_bar),
                    tint = Color.White,
                    modifier = Modifier.padding(end = 8.dp)
                    )
            },
            colors = TopAppBarDefaults.topAppBarColors(colorResource(R.color.navy))

        )

//        Content
        Column(modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            InputTextFied(modifier = Modifier.fillMaxWidth(), text = title.value, label = "Title", onTextChange = {
                if(it.all { char ->
                    char.isLetter() || char.isWhitespace()
                }) title.value = it
            })
            Spacer(modifier = Modifier.padding(4.dp))
            InputTextFied(modifier = Modifier.fillMaxWidth(),text = desc.value, label = "Description", onTextChange = {
                if(it.all { char ->
                    char.isLetter() || char.isWhitespace()
                    }) desc.value = it
            })
            Spacer(modifier = Modifier.padding(8.dp))
            ButtonCustom(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp), text = "Submit", onClick = {
                if(title.value.isNotEmpty() && desc.value.isNotEmpty()){
                    title.value = ""
                    desc.value = ""
                }
            })

        }

    }

}

@Preview(showBackground = true)
@Composable
fun NoteScreensPreview(){
    NoteScreens(notes = emptyList(), {}, {})
}