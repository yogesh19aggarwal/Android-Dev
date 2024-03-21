package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val listView = binding.listView

        val taskList = arrayListOf<String>()
        taskList.add("Attend Exam")
        taskList.add("Complete the App dev Project")
        taskList.add("Buy Bhindi from market")
        taskList.add("Work on resume")
        taskList.add("Improve internet Presence")

        val adapterForListView = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)
        listView.adapter = adapterForListView

        listView.setOnItemClickListener { parent, view, position, id ->
            val text = "Clicked on Item : " + (view as TextView).text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}