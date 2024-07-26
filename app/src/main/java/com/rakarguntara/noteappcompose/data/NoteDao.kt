package com.rakarguntara.noteappcompose.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.rakarguntara.noteappcompose.models.NotesModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes_table")
    fun getAllNote(): Flow<List<NotesModel>>

    @Query("SELECT * FROM notes_table WHERE id= :id")
    suspend fun getNoteById(id: String): NotesModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(notesModel: NotesModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(notesModel: NotesModel)

    @Query("DELETE FROM notes_table")
    suspend fun deleteAllNote()

    @Delete
    suspend fun deleteNoteById(notesModel: NotesModel)
}