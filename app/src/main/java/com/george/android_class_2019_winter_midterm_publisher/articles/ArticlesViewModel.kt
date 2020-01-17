package com.george.android_class_2019_winter_midterm_publisher.articles

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.george.android_class_2019_winter_midterm_publisher.data.Article
import com.george.android_class_2019_winter_midterm_publisher.data.source.FirestoreRepository
import com.george.android_class_2019_winter_midterm_publisher.util.convertLongToDateString
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot

class ArticlesViewModel : ViewModel() {


    val TAG = "FIRESTORE_VIEW_MODEL"
    var firebaseRepository = FirestoreRepository()
    private val articles = MutableLiveData<List<Article>>()

    val formatedCreatedTime = Transformations.map(articles) {

        var time: String? = null
        it.forEach { article -> time = convertLongToDateString(article.createdTime) }

        time

    }

    // get realtime updates from firebase regarding saved articles
    fun getArticles(): LiveData<List<Article>> {
        firebaseRepository.getArticles().orderBy("createdTime", Query.Direction.DESCENDING)
            .addSnapshotListener(EventListener<QuerySnapshot> { value, e ->
                if (e != null) {
                    Log.i(TAG, "Listen failed.", e)
                    articles.value = null
                    return@EventListener
                }

                val articleList: MutableList<Article> = mutableListOf()
                for (doc in value!!) {
                    val article = doc.toObject(Article::class.java)
                    articleList.add(article)
                }
                articles.value = articleList
            })

        return articles
    }
}