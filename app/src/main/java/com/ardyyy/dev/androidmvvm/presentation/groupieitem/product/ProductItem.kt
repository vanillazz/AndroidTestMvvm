package com.ardyyy.dev.androidmvvm.presentation.groupieitem.product

import coil.api.load
import com.ardyyy.dev.androidmvvm.R
import com.ardyyy.dev.androidmvvm.data.models.response.ItemHome
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.list_item_product.view.*

class ProductItem(private val product: ItemHome, private var onClick: (ItemHome) -> Unit) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            tvProductName.text = product.product_name
            ivProductImage.load(product.product_image) {
                crossfade(true)
            }
            setOnClickListener {
                onClick.invoke(product)
            }
        }
    }

    override fun getLayout(): Int = R.layout.list_item_product

}