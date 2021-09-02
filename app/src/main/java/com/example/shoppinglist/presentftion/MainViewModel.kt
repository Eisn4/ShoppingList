package com.example.shoppinglist.presentftion

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopListRepositoryImpl
import com.example.shoppinglist.domain.*

class MainViewModel : ViewModel() {

    private val shopListRepository = ShopListRepositoryImpl

    private val getShopListUserCase = GetShopListUserCase(shopListRepository)
    private val deleteItemUserCase = DeleteItemUserCase(shopListRepository)
    private val editShopItemUserCase = EditShopItemUserCase(shopListRepository)
    private val addItemUserCase = AddItemUserCase(shopListRepository)

    val shopList = getShopListUserCase.getShopList()

    fun addShopItem (item: ShopItem){
        addItemUserCase.addItem(item)
    }

    fun deleteShopItem(item: ShopItem){
        deleteItemUserCase.deleteItem(item)
    }

    fun changeEnableState(item: ShopItem){
        val newItem = item.copy(enabled = !item.enabled)
        editShopItemUserCase.editItem(newItem)
    }

}