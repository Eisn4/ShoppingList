package com.example.shoppinglist.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl:ShopListRepository {
    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0
                    get() = field++

    init {
        repeat(10) {
            addShopItem(ShopItem("Name $it", it, true))
        }
    }

    override fun editItem(item: ShopItem) {
        val tempItem = getShopItem(item.id)
        deleteItem(item)
        addShopItem(tempItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException ("Not FOUND shopItem id = $shopItemId")
    }

    override fun deleteItem(item: ShopItem) {
        shopList -= item
        updateList()
    }

    override fun addShopItem(item: ShopItem) {
        if (item.id == ShopItem.UNDEFINED_ID) item.id = autoIncrementId
        shopList += item
        updateList()
    }

    override fun getShopList(): LiveData<List<ShopItem>> = shopListLD

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}