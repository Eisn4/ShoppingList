package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class GetShopListUserCase(private val shopListRepository: ShopListRepository) {
    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}