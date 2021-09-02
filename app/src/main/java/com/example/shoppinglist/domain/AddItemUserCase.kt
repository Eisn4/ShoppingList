package com.example.shoppinglist.domain

class AddItemUserCase(private val shopListRepository: ShopListRepository) {
    fun addItem(shopItem: ShopItem){
        shopListRepository.addShopItem(shopItem)
    }
}