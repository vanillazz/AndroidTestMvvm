package com.ardyyy.dev.androidmvvm.presentation.groupieitem.article

import androidx.recyclerview.widget.LinearLayoutManager
import com.ardyyy.dev.androidmvvm.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_home_article.view.*

class HomeArticleItem(
    private val title: String?,
    private val groupAdapter: GroupAdapter<GroupieViewHolder>
) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.tvSectionTitle.text = title
        viewHolder.itemView.rvArticle.apply {
            layoutManager = LinearLayoutManager(viewHolder.itemView.context)
            adapter = groupAdapter
        }
    }

    override fun getLayout(): Int = R.layout.item_home_article


}