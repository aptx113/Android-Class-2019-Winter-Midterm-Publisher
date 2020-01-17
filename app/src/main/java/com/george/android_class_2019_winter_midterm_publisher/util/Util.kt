package com.george.android_class_2019_winter_midterm_publisher.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat


@SuppressLint("SimpleDateFormat")
fun convertLongToDateString(calendarTime: Long): String {
    return SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
        .format(calendarTime).toString()
}
