package com.rakarguntara.noteappcompose.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rakarguntara.noteappcompose.R
import com.rakarguntara.noteappcompose.data.DummyDataNotesModel
import com.rakarguntara.noteappcompose.models.NotesModel
import java.time.format.DateTimeFormatter

@Composable
fun NotesListItem(data: NotesModel, onItemClick: (NotesModel) -> Unit){
    Card (modifier = Modifier.fillMaxWidth()
        .padding(bottom = 8.dp)
        .clickable {
            onItemClick(data)
        }
        ,
        shape = RoundedCornerShape(topStart = 12.dp, bottomEnd = 12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(colorResource(R.color.grey)),
        border = BorderStroke(1.dp, color = colorResource(R.color.navy)),
    ){
        Row (
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ){
                Text(data.title, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.padding(start = 8.dp))
                Text(data.desc, style = MaterialTheme.typography.bodySmall)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(data.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")),
                    style = TextStyle(
                        color = Color.DarkGray,
                        fontSize = 10.sp
                    )
                )
            }

        }
    }
}

@Preview
@Composable
fun NotesListItemPreview(){
    NotesListItem(DummyDataNotesModel().loadNotes()[1], {})
}