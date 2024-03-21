package com.example.datatravell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
//import kotlinx.android.synthetic.main.activity_show_order.tvOrder

//import kotlinx.android.synthetic.main.activity_show_order.tvOrder

//import kotlinx.android.synthetic.main.activity_show_order.*

class ShowOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_order)

        val orderOfcustomer = intent.getStringExtra(MainActivity.KEY)

        findViewById<TextView>(R.id.tvOrder).text = orderOfcustomer.toString()
    }
}