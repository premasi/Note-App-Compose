package com.rakarguntara.noteappcompose.repository

import com.rakarguntara.noteappcompose.data.NoteDao
import com.rakarguntara.noteappcompose.models.NotesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NotesRepository @Inject constructor(private val noteDao: NoteDao) {
    suspend fun addNote(notesModel: NotesModel) = noteDao.insertNote(notesModel)
    suspend fun updateNote(notesModel: NotesModel) = noteDao.updateNote(notesModel)
    suspend fun deleteNote(notesModel: NotesModel) = noteDao.deleteNoteById(notesModel)
    suspend fun deleteAllNote() = noteDao.deleteAllNote()
    fun getAllNote(): Flow<List<NotesModel>> = noteDao.getAllNote().flowOn(Dispatchers.IO)
        .conflate()
}