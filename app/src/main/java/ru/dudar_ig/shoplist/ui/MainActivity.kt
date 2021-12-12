package ru.dudar_ig.shoplist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import ru.dudar_ig.shoplist.R
import ru.dudar_ig.shoplist.domain.ShopItem

class MainActivity : AppCompatActivity() {

   private val viewModel by viewModels<MainViewModel>()
    private lateinit var llShopList: LinearLayout

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       llShopList = findViewById(R.id.ll_shop_list)

        viewModel.shopListLD.observe(this, Observer {
            showList(it)
        })



    }

    private fun showList(list: List<ShopItem>) {
        llShopList.removeAllViews()
        for(shopItem in list) {
            val layoutId = if(shopItem.enabled) {
                R.layout.item_shop_enabled
            } else {
                R.layout.item_shop_disabled
            }
            val view = LayoutInflater.from(this).inflate(layoutId, llShopList, false)
            val tvName = view.findViewById<TextView>(R.id.name_tv)
            val tvCount = view.findViewById<TextView>(R.id.count_tv)
            tvName.text = shopItem.name
            tvCount.text = shopItem.count.toString()
            view.setOnLongClickListener{
                viewModel.changeEnableItem(shopItem)
                true
            }
            llShopList.addView(view)
        }
    }
}