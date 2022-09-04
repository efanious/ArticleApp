package com.example.android.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.R
import com.example.android.adapters.ArticlesAdapter
import com.example.android.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val articlesRView: RecyclerView = findViewById(R.id.popular_articles_recycler_view)
        articlesRView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val popularArticlesAdapter = ArticlesAdapter()

        viewModel.getArticles()

        viewModel.response.observe(this) { result ->
            when (result) {
                is Resource.Success -> {
                    //Toast.makeText(this, "num_results: ${result.data?.num_results}", Toast.LENGTH_SHORT).show()
                    popularArticlesAdapter.data = result.data?.results!!
                    articlesRView.adapter = popularArticlesAdapter
                }
                is Resource.Error -> {
                    Toast.makeText(this, result.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {

                }
            }
        }
    }
}