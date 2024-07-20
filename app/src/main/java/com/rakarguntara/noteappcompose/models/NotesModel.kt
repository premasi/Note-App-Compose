package com.rakarguntara.noteappcompose.models

import java.time.LocalDateTime
import java.util.UUID

data class NotesModel(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val desc: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
