package com.example.android.presentation.article_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.android.R
import com.example.android.models.ArticlesResult

class ArticleDetailActivity : AppCompatActivity() {

    private lateinit var articlesResult: ArticlesResult

    private lateinit var titleTextView: TextView
    private lateinit var sourceTextView: TextView
    private lateinit var publishedDateTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)

        articlesResult = intent.getParcelableExtra("Article")!!

        titleTextView = findViewById(R.id.titleTextView)
        sourceTextView = findViewById(R.id.sourceTextView)
        publishedDateTextView = findViewById(R.id.publishedDateTextView)

        displayInfo(articlesResult)

    }

    private fun displayInfo(articlesResult: ArticlesResult) {
        titleTextView.text = articlesResult.title
        sourceTextView.text = "Source: ${articlesResult.source}"
        publishedDateTextView.text = "Date published: ${articlesResult.published_date}"
    }
}