package com.rakarguntara.noteappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.rakarguntara.noteappcompose.data.DummyDataNotesModel
import com.rakarguntara.noteappcompose.models.NotesModel
import com.rakarguntara.noteappcompose.screens.NoteScreens
import com.rakarguntara.noteappcompose.ui.theme.NoteAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteAppComposeTheme {
                Surface {
                    val list = remember { mutableStateListOf<NotesModel>() }
                    NoteScreens(list, {
                        list.add(it)
                    }, {
                        list.remove(it)
                    })
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteAppComposeTheme {
        NoteScreens(DummyDataNotesModel().loadNotes(), {}, {})
    }
}