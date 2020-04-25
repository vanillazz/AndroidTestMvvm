package com.ardyyy.dev.androidmvvm.presentation.base

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    fun openUrl(url: String){
        try {
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse(url)))
        } catch (e: Exception){

        }
    }
}