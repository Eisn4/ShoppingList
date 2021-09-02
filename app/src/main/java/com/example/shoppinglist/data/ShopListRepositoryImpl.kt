package com.example.shoppinglist.data

import android.util.Log
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl:ShopListRepository {

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
    }

    override fun addShopItem(item: ShopItem) {
        if (item.id == ShopItem.UNDEFINED_ID) item.id = autoIncrementId
        shopList += item
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}