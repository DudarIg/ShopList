package ru.dudar_ig.shoplist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
//import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.dudar_ig.shoplist.R

class MainActivity : AppCompatActivity() {

   private lateinit var viewModel: MainViewModel
   //private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shopListLD.observe(this, Observer {
            Log.d("WWW",it.toString())
        })



    }
}