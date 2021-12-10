package ru.dudar_ig.shoplist.domain

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)
    fun delShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItem: Int): ShopItem
    fun getShopList(): List<ShopItem>
}