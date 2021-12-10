package ru.dudar_ig.shoplist.domain

class GetShopItemIter(
    private val shopListRepository: ShopListRepository
) {
    fun getShopItem(shopItem: Int): ShopItem {
        return shopListRepository.getShopItem(shopItem)
    }
}