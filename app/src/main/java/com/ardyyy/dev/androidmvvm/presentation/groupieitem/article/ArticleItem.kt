package com.ardyyy.dev.androidmvvm.presentation.groupieitem.article

import coil.api.load
import com.ardyyy.dev.androidmvvm.R
import com.ardyyy.dev.androidmvvm.data.models.response.ItemHome
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.list_item_article.view.*

class ArticleItem(private val article: ItemHome, private var onClick: (ItemHome) -> Unit) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            tvArticleTitle.text = article.article_title
            ivArticleImage.load(article.article_image) {
                crossfade(750)
            }
            cardArticle.setOnClickListener {
                onClick.invoke(article)
            }
        }
    }

    override fun getLayout(): Int = R.layout.list_item_article

}