package com.rakarguntara.noteappcompose.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun dateFormatter(time: Long) : String {
    val date = java.util.Date(time)
    val format = SimpleDateFormat("EEE, d MMM hh:mm aaa", Locale.getDefault())
    return format.format(date)
}