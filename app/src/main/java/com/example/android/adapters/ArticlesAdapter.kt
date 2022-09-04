package com.example.android.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.R
import com.example.android.data.dto.ArticlesResultDto
import com.example.android.presentation.article_detail.ArticleDetailActivity

class ArticlesAdapter : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    var data = listOf<ArticlesResultDto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.article_item_view, parent, false)
        return ArticleViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size

    class ArticleViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private var article: ArticlesResultDto? = null

        private val titleText: TextView = itemView.findViewById(R.id.articleTitleTextView)
        private val articleImage: ImageView = itemView.findViewById(R.id.article_image)

        init {
            itemView.setOnClickListener {
                article?.let {
                    onClick(it)
                }
            }
        }

        private fun onClick(articleClicked: ArticlesResultDto) {

//            Toast.makeText(
//                itemView.context,
//                "${articleClicked.title} clicked!!! ",
//                Toast.LENGTH_SHORT
//            ).show()

            val intent = Intent(itemView.context, ArticleDetailActivity::class.java)
            intent.putExtra("Article", articleClicked.toArticlesResult())
            itemView.context.startActivity(intent)

        }

        fun bind(mArticle: ArticlesResultDto) {
            article = mArticle
            titleText.text = article!!.title

            val articleImageUrl = article!!.media?.get(0)?.mediaMetadata?.get(2)?.url

            Glide.with(itemView.context)
                .load(articleImageUrl)
                .skipMemoryCache(true)
                .into(articleImage)

        }
    }


}