package com.esma.movieapp.utils

import androidx.compose.ui.graphics.Color
import java.text.SimpleDateFormat
import java.util.*

fun String?.formatDateBetweenPatterns(fromPattern: String, toPattern: String): String {
    var dispStr = ""
    try {
        val fromFormat = SimpleDateFormat(fromPattern, Locale("tr"))
        val toFormat = SimpleDateFormat(toPattern, Locale("tr"))
        fromFormat.parse(
            this?.take(10) ?: ""
        )?.let {
            val calender = GregorianCalendar.getInstance()
            calender.time = it
            dispStr = toFormat.format(calender.time)
        }
    } catch (e: Exception) {
    }
    return dispStr
}

fun Double.toColor(): Color {
    return when {
        this < 2.5 -> Color.Red
        this < 5 -> Color(255, 160, 0)
        this < 7.5 -> Color.Yellow
        else -> Color.Green
    }
}
