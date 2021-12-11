package ru.dudar_ig.shoplist.data

import ru.dudar_ig.shoplist.domain.ShopItem
import ru.dudar_ig.shoplist.domain.ShopListRepository
import java.lang.RuntimeException

class ShopListRepositopyImpl: ShopListRepository {
    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    init {
        (1..10).forEach {
            val item = ShopItem("Name $it", it, true)
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        shopItem.id = autoIncrementId++
        shopList.add(shopItem)
    }

    override fun delShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        shopList.add(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Элемент не найден")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

}