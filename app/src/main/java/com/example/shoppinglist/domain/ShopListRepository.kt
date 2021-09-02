package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface ShopListRepository {
    fun editItem(item: ShopItem)
    fun getShopItem(shopItemId: Int): ShopItem
    fun deleteItem(item: ShopItem)
    fun addShopItem(item: ShopItem)
    fun getShopList(): LiveData<List<ShopItem>>
}