package ru.dudar_ig.shoplist.domain

class GetShopListIter(
    private val shopListRepository: ShopListRepository
) {
    fun getShopList(): List<ShopItem> {
        return shopListRepository.getShopList()
    }
}