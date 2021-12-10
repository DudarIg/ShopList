package ru.dudar_ig.shoplist.domain

class AddShopItemIter(
    private val shopListRepository: ShopListRepository
) {
    fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)

    }
}