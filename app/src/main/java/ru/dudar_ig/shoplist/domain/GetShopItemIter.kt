package ru.dudar_ig.shoplist.domain

class GetShopItemIter(
    private val shopListRepository: ShopListRepository
) {
    fun getShopItem(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItem(shopItemId)
    }
}