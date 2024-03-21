package com.example.day22project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var userArrayList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("Soumya", "Prastuti", "Ankit", "Pradeep", "Aman")

        val lastMsg = arrayOf("Hey everyone", "I am fine", "good", "Awesome", "Cool")
        val lastMsgTime = arrayOf("6:25 AM", "7:30 PM", "5:00 PM", "6:25 AM", "7:30 PM")

        val phoneNumber = arrayOf("7894561235", "7894561245", "7894561239", "7894461235", "7884561235")
        val imgId = intArrayOf(R.drawable.user1_img, R.drawable.user2_img, R.drawable.user3_img, R.drawable.user4_img,
            R.drawable.user5_img)

        userArrayList = ArrayList()
        for(i in name.indices){
            val user = User(name[i], lastMsg[i], lastMsgTime[i], phoneNumber[i], imgId[i])

            userArrayList.add(user)
        }

        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true

        listView.adapter = MyAdapter(this, userArrayList)

    }
}