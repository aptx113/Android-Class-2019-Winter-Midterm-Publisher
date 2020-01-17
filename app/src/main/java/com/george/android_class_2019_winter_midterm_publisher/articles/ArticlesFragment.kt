package com.george.android_class_2019_winter_midterm_publisher.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.george.android_class_2019_winter_midterm_publisher.databinding.FragmentArticlesBinding

class ArticlesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = FragmentArticlesBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        val viewModel = ViewModelProviders.of(this).get(ArticlesViewModel::class.java)
        binding.viewModel = viewModel

        binding.recyclerArticle.adapter = ArticlesAdapter()

        binding.layoutSwipeRefreshArticle.setOnRefreshListener {
            binding.recyclerArticle.adapter?.notifyDataSetChanged()
            binding.layoutSwipeRefreshArticle.isRefreshing = false
        }

        return binding.root
    }

}