package com.rakarguntara.noteappcompose.utils

import androidx.room.TypeConverter
import java.util.UUID

class UUIDTypeConverter {
    @TypeConverter
    fun fromString(value: String): UUID{
        return value.let { UUID.fromString(it) }!!
    }

    @TypeConverter
    fun fromUUID(uuid: UUID): String{
        return uuid.toString()
    }
}