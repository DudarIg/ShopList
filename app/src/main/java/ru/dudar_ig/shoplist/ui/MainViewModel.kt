package ru.dudar_ig.shoplist.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.dudar_ig.shoplist.data.ShopListRepositopyImpl
import ru.dudar_ig.shoplist.domain.ShopItem

class MainViewModel: ViewModel() {
    private val repository = ShopListRepositopyImpl()

    val shopListLD : LiveData<List<ShopItem>>
    init {
        val shopList = MutableLiveData<List<ShopItem>>()
        val list = repository.getShopList()
        shopList.postValue(list)
        shopListLD = shopList
    }

}