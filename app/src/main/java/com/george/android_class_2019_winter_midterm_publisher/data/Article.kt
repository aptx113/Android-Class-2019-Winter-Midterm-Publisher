package com.george.android_class_2019_winter_midterm_publisher.data

import android.os.Parcelable
import com.george.android_class_2019_winter_midterm_publisher.util.ArticleTagType
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Article(

    val author: Author = Author(),
    val title: String = "",
    val content: String = "",
    val createdTime: Long = Calendar.getInstance().timeInMillis,
    val id: String = "",
    val tag: ArticleTagType = ArticleTagType.Beauty
):Parcelable