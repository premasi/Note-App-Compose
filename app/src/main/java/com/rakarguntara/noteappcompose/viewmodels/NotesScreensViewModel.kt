package com.rakarguntara.noteappcompose.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.rakarguntara.noteappcompose.data.DummyDataNotesModel
import com.rakarguntara.noteappcompose.models.NotesModel

class NotesScreensViewModel : ViewModel() {
    private val noteList = mutableStateListOf<NotesModel>()

    init {
        noteList.addAll(DummyDataNotesModel().loadNotes())
    }

    fun addNoteList(notesModel: NotesModel){
        noteList.add(notesModel)
    }

    fun removeNoteList(notesModel: NotesModel){
        noteList.remove(notesModel)
    }

    fun getAllNoteList(): List<NotesModel>{
        return noteList
    }
}