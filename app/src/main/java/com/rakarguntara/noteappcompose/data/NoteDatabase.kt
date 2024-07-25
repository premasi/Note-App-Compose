package com.rakarguntara.noteappcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rakarguntara.noteappcompose.models.NotesModel

@Database(entities = [NotesModel::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}