package com.rakarguntara.noteappcompose.data

import com.rakarguntara.noteappcompose.models.NotesModel

class DummyDataNotesModel{
    fun loadNotes(): List<NotesModel>{
        return listOf(
            NotesModel(title = "Satu", desc = "Aku anak sehat tubuhku kuat"),
            NotesModel(title = "2", desc = "Hello how are you?")
        )
    }
}