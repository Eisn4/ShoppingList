package com.example.shoppinglist.domain

class DeleteItemUserCase(private val shopListRepository: ShopListRepository) {
    fun deleteItem(item: ShopItem){
        shopListRepository.deleteItem(item)
    }
}