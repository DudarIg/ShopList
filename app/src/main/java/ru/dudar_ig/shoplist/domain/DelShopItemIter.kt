package ru.dudar_ig.shoplist.domain

class DelShopItemIter(
    private val shopListRepository: ShopListRepository
) {
    fun delShopItem(shopItem: ShopItem) {
        shopListRepository.delShopItem(shopItem)

    }
}