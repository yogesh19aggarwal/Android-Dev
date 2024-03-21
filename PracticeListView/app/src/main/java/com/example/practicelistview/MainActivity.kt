package com.example.practicelistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var userArrayList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("Yogesh", "Ankit", "Prastuti", "Pradeep", "Aman")
        val lastMsg = arrayOf("Hey, I am good", "Hello, Welcome", "Its completely fine", "Wow", "I am fine")
        val lastMsgTime = arrayOf("6:00 AM", "2:45 PM", "8:28 AM", "4:43 PM", "7:23 PM")
        val phoneNumber = arrayOf("9354313779", "7827479736", "9865781476", "7827459736", "9354812778")
        val img_id = arrayOf(R.drawable.user1_img, R.drawable.user2_img, R.drawable.user3_img,
            R.drawable.user4_img, R.drawable.user5_img)

        userArrayList = ArrayList()
        for(i in name.indices){
            val user = User(name[i], lastMsg[i], lastMsgTime[i], phoneNumber[i], img_id[i])

            userArrayList.add(user)
        }

        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true

        listView.adapter = MyAdapter(this, userArrayList)

        listView.setOnItemClickListener { parent, view, position, id ->

            val userName =  name[position]
            val userPhone = phoneNumber[position]
            val imgId = img_id[position]

            val intent = Intent(this, UserActivity :: class.java)

            intent.putExtra("name", userName)
            intent.putExtra("phone", userPhone)
            intent.putExtra("imageId", imgId)
            startActivity(intent)
        }
    }
}