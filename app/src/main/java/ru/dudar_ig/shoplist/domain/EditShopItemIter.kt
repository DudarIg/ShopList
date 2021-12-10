package ru.dudar_ig.shoplist.domain

class EditShopItemIter(
    private val shopListRepository: ShopListRepository
) {
    fun editShopItem(shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)

    }
}