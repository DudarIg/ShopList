package ru.dudar_ig.shoplist.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.dudar_ig.shoplist.data.ShopListRepositopyImpl
import ru.dudar_ig.shoplist.domain.ShopItem

class MainViewModel: ViewModel() {
    private val repository = ShopListRepositopyImpl()

    val shopListLD = repository.getShopList()

    fun delItem(shopItem: ShopItem) {
        repository.delShopItem(shopItem)
    }

    fun changeEnableItem(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        repository.editShopItem(newItem)
    }




}