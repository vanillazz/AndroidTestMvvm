package com.ardyyy.dev.androidmvvm.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ardyyy.dev.androidmvvm.R
import com.ardyyy.dev.androidmvvm.data.models.response.ItemHome
import com.ardyyy.dev.androidmvvm.presentation.base.BaseActivity
import com.ardyyy.dev.androidmvvm.presentation.groupieitem.article.ArticleItem
import com.ardyyy.dev.androidmvvm.presentation.groupieitem.article.HomeArticleItem
import com.ardyyy.dev.androidmvvm.presentation.groupieitem.product.HomeProductItem
import com.ardyyy.dev.androidmvvm.presentation.groupieitem.product.ProductItem
import com.ardyyy.dev.androidmvvm.utils.NetworkHelper
import com.ardyyy.dev.androidmvvm.utils.UiState
import com.ardyyy.dev.androidmvvm.utils.showShortToast
import com.facebook.shimmer.ShimmerFrameLayout
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.viewmodel.ext.android.viewModel



class HomeActivity : BaseActivity() {

    private val homeViewModel: HomeViewModel by viewModel()
    private var groupAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        initAdapter()
        initProcess()
    }

    private fun initProcess() {
        homeViewModel.homeData.observe(this@HomeActivity, Observer {
            val shimmer = homeShimmer as ShimmerFrameLayout

            when (it) {
                is UiState.Loading -> {
                    println("loading")
                    shimmer.visibility = View.VISIBLE
                    rvHome.visibility = View.GONE
                    shimmer.startShimmer()

                }
                is UiState.Success -> {
                    shimmer.visibility = View.GONE
                    rvHome.visibility = View.VISIBLE
                    shimmer.stopShimmer()

                    val articles = it.data.data[0]
                    val products = it.data.data[1].items

                    Section().apply {
                        add(makeProduct(products))
                        groupAdapter.add(this)
                    }

                    Section().apply {
                        add(makeArticle(articles.section_title, articles.items))
                        groupAdapter.add(this)
                    }
                }
                is UiState.Error -> {
                    shimmer.visibility = View.GONE
                    shimmer.stopShimmer()
                    val message = NetworkHelper().getErrorMessage(it.throwable)
                    this@HomeActivity.showShortToast(message)
                }
            }
        })
        homeViewModel.getHomeData()
    }

    private fun makeProduct(products: List<ItemHome>): HomeProductItem {
        val productItemGroupAdapter = GroupAdapter<GroupieViewHolder>()
        products.map { productItem ->
            productItemGroupAdapter.add(
                ProductItem(
                    productItem
                ) { product ->
                    product.apply {
                        Log.d("TEST", "clicked item $link")
                        link?.let { openUrl(it) }
                    }
                }
            )
        }
        return HomeProductItem(
            productItemGroupAdapter
        )
    }

    private fun makeArticle(title: String?, article: List<ItemHome>): HomeArticleItem {
        val articleItemGroupAdapter = GroupAdapter<GroupieViewHolder>()
        article.map { articleItem ->
            articleItemGroupAdapter.add(
                ArticleItem(
                    articleItem
                ) { article ->
                    article.apply {
                        Log.d("TEST", "clicked item $link")
                        link?.let { openUrl(it) }
                    }
                }
            )
        }
        return HomeArticleItem(
            title,
            articleItemGroupAdapter
        )
    }

    private fun initAdapter() {
        rvHome.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = groupAdapter
        }
    }
}
