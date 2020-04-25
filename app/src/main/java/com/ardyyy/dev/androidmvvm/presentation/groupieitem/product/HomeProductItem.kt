package com.ardyyy.dev.androidmvvm.presentation.groupieitem.product

import androidx.recyclerview.widget.GridLayoutManager
import com.ardyyy.dev.androidmvvm.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_home_product.view.*

class HomeProductItem(private val groupAdapter: GroupAdapter<GroupieViewHolder>) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val dimenDp = viewHolder.itemView.context.resources.getDimensionPixelSize(R.dimen.dimen2dp)
        val column = 3

        viewHolder.itemView.rvProduct.apply {
            adapter = groupAdapter
            layoutManager = GridLayoutManager(viewHolder.itemView.context, column)
//            addItemDecoration(GridItemDecoration(dimenDp, column))
        }
    }

    override fun getLayout(): Int = R.layout.item_home_product
}