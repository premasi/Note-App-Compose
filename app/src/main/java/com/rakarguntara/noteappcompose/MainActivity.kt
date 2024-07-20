package com.rakarguntara.noteappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rakarguntara.noteappcompose.screens.NoteScreens
import com.rakarguntara.noteappcompose.ui.theme.NoteAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteAppComposeTheme {
                Surface {
                    NoteScreens(emptyList(), {}, {})
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteAppComposeTheme {
        NoteScreens(emptyList(), {}, {})
    }
}