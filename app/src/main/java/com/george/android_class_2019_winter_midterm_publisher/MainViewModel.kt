package com.george.android_class_2019_winter_midterm_publisher

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.george.android_class_2019_winter_midterm_publisher.data.Article
import com.george.android_class_2019_winter_midterm_publisher.data.Author
import com.george.android_class_2019_winter_midterm_publisher.util.ArticleTagType
import com.george.android_class_2019_winter_midterm_publisher.util.CurrentFragmentType
import com.george.android_class_2019_winter_midterm_publisher.util.convertLongToDateString
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel : ViewModel() {

    val db = FirebaseFirestore.getInstance()

    // Record current fragment to support data binding
    val currentFragmentType = MutableLiveData<CurrentFragmentType>()

    private val article = MutableLiveData<Article>()

    fun publishArticles() {

        val articles = db.collection("articles")
        val document = articles.document()

        val calendar = Calendar.getInstance().timeInMillis
        val author = Author("wayne@school.appworks.tw", "waynechen323", "AKA小安老師")

        val data = Article(author,"​IU「亂穿」竟美出新境界！笑稱自己品味奇怪　網笑：靠顏值撐住女神氣場", "南韓歌手IU（李知恩）無論在歌唱方面或是近期的戲劇作品\n" +
                "都有亮眼的成績，但俗話說人無完美、美玉微瑕，曾再跟工作人員的互動影片中坦言\n" +
                "自己品味很奇怪，近日在IG上分享了宛如「媽媽們青春時代的玉女歌手」超復古穿搭\n" +
                "造型，卻意外美出新境界。",calendar,document.id,ArticleTagType.Beauty)

        document.set(data)
    }
}