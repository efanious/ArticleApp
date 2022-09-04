package com.example.android.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.android.R
import com.example.android.data.dto.ArticlesResultDto

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


        init {
            itemView.setOnClickListener {
                article?.let {
                    onClick(it)
                }
            }
        }

        private fun onClick(articleClicked: ArticlesResultDto) {

            Toast.makeText(
                itemView.context,
                "${articleClicked.title} clicked!!! ",
                Toast.LENGTH_SHORT
            ).show()

//            val intent = Intent(itemView.context, ArticleDetailActivity::class.java)
//            intent.putExtra("Article", articleClicked)
//            itemView.context.startActivity(intent)

        }

        fun bind(mArticle: ArticlesResultDto) {
            article = mArticle
            titleText.text = article!!.title

        }
    }


}