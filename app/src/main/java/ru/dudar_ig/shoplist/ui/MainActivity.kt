package ru.dudar_ig.shoplist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import ru.dudar_ig.shoplist.R
import ru.dudar_ig.shoplist.domain.ShopItem

class MainActivity : AppCompatActivity() {

   private val viewModel by viewModels<MainViewModel>()
    private lateinit var adapter: ShopListAdapter

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       setupRecyclerView()

        viewModel.shopListLD.observe(this, Observer {
                adapter.shopList = it
        })
    }

    private fun setupRecyclerView() {
        val rvShopList = findViewById<RecyclerView>(R.id.rv_shop_list)
        adapter = ShopListAdapter()
        rvShopList.adapter = adapter
        rvShopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_ENABLED,
                                                        ShopListAdapter.MAX_POOL_SIZE)
        rvShopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_DISABLED,
                                                        ShopListAdapter.MAX_POOL_SIZE)

        setupClickAndSwipe(rvShopList)
    }

    private fun setupClickAndSwipe(rvShopList: RecyclerView) {
        adapter.funLongClick = {
            viewModel.changeEnableItem(it)
        }

        adapter.funShortClick = {
            Log.d("Short", it.toString())
        }

        // создаем callback - обратный вызов
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = adapter.shopList[viewHolder.adapterPosition]
                viewModel.delItem(item)
            }
        }
        // создаем переменную и прикрепляем к RecyclerView
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rvShopList)
    }


}