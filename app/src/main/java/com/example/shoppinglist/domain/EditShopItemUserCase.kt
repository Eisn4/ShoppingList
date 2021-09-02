package com.example.shoppinglist.domain

class EditShopItemUserCase(private val shopListRepository: ShopListRepository) {
    fun editItem(item: ShopItem){
        shopListRepository.editItem(item)
    }
}