package com.rakarguntara.noteappcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rakarguntara.noteappcompose.models.NotesModel
import com.rakarguntara.noteappcompose.utils.DateTypeConverter
import com.rakarguntara.noteappcompose.utils.UUIDTypeConverter

@Database(entities = [NotesModel::class], version = 1, exportSchema = false)
@TypeConverters(UUIDTypeConverter::class, DateTypeConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}