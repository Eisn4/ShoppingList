package com.example.shoppinglist.presentftion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: MainViewModel
    private var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shopList.observe(this){
            Log.e("TAGG_LIST","Observe ${it.joinToString()}")
            if (i==0) {
                viewModel.deleteShopItem(it[0])
                i++
            }
        }

    }
}