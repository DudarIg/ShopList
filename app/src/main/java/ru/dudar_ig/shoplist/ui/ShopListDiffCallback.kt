package ru.dudar_ig.shoplist.ui

import androidx.recyclerview.widget.DiffUtil
import ru.dudar_ig.shoplist.domain.ShopItem

class ShopListDiffCallback(
    private val oldList: List<ShopItem>,
    private val newList: List<ShopItem>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    // сравнивает id элементов изменений
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.id == newItem.id
    }
   // сравнивает поля элементов изменений
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       val oldItem = oldList[oldItemPosition]
       val newItem = newList[newItemPosition]
       return oldItem == newItem
   }

}