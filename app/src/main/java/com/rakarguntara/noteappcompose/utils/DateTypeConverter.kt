package com.rakarguntara.noteappcompose.utils

import androidx.room.TypeConverter
import java.util.Date

class DateTypeConverter {
    @TypeConverter
    fun fromTimeStamp(value: Long): Date{
        return value.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimeStamp(date: Date): Long{
        return date.time
    }
}