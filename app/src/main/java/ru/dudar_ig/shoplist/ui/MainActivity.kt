package ru.dudar_ig.shoplist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
//import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.dudar_ig.shoplist.R

class MainActivity : AppCompatActivity() {

   private val viewModel by viewModels<MainViewModel>()

    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel.shopListLD.observe(this, Observer {
            Log.d("WWW",it.toString())
            if (count == 0) {
                count++
                val item = it[1]
                viewModel.changeEnableItem(item)

            }

        })



    }
}