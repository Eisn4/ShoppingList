package com.example.shoppinglist.domain

interface ShopListRepository {
    fun editItem(item: ShopItem)
    fun getShopItem(shopItemId: Int): ShopItem
    fun deleteItem(item: ShopItem)
    fun addShopItem(item: ShopItem)
    fun getShopList(): List<ShopItem>
}