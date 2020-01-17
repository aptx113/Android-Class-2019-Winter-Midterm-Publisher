package com.george.android_class_2019_winter_midterm_publisher

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.george.android_class_2019_winter_midterm_publisher.articles.ArticlesAdapter
import com.george.android_class_2019_winter_midterm_publisher.data.Article
import com.george.android_class_2019_winter_midterm_publisher.util.convertLongToDateString

@BindingAdapter("articles")
fun bindRecyclerViewWithArticles(recyclerView: RecyclerView, articles: List<Article>?) {
    articles?.let {
        recyclerView.adapter?.apply {
            when (this) {
                is ArticlesAdapter -> {
                    when (itemCount) {
                        0 -> submitList(it)
                        it.size -> notifyDataSetChanged()
                        else -> submitList(it)
                    }
                }

            }
        }
    }

}

@BindingAdapter("time")
fun bindTime(textView: TextView, time: Long?) {
    time?.let { textView.text = convertLongToDateString(time) }
}