package ru.dudar_ig.shoplist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.dudar_ig.shoplist.domain.ShopItem
import ru.dudar_ig.shoplist.domain.ShopListRepository
import java.lang.RuntimeException
import kotlin.random.Random

class ShopListRepositopyImpl: ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = sortedSetOf<ShopItem>({
        o1, o2 -> o1.id.compareTo(o2.id) })

    private var autoIncrementId = 0

    init {
        (0..2000).forEach {
            val item = ShopItem("Name $it", it, Random.nextBoolean())
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        shopItem.id = autoIncrementId++
        shopList.add(shopItem)
        updateLD()
    }

    override fun delShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateLD()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        shopList.add(shopItem)
        updateLD()
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Элемент не найден")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    private fun updateLD() {
        shopListLD.value = shopList.toList()
    }

}