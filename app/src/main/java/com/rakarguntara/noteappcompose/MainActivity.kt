package com.rakarguntara.noteappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rakarguntara.noteappcompose.data.DummyDataNotesModel
import com.rakarguntara.noteappcompose.screens.NoteScreens
import com.rakarguntara.noteappcompose.ui.theme.NoteAppComposeTheme
import com.rakarguntara.noteappcompose.viewmodels.NotesScreensViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteAppComposeTheme {
                Surface {
                    val notesScreensViewModel: NotesScreensViewModel by viewModels()
                    NotesApp(notesScreensViewModel)
                }
            }
        }
    }
}

@Composable
fun NotesApp(notesScreensViewModel: NotesScreensViewModel = viewModel()){
    NoteScreens(notesScreensViewModel.getAllNoteList(), { notesScreensViewModel.addNoteList(it) },
        { notesScreensViewModel.removeNoteList(it) })
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteAppComposeTheme {
        NoteScreens(DummyDataNotesModel().loadNotes(), {}, {})
    }
}