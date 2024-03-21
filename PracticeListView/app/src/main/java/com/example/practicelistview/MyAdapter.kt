package com.example.practicelistview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(val context : Activity, val userArrayList: ArrayList<User>) : ArrayAdapter<User>(context, R.layout.each_item, userArrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflator = LayoutInflater.from(context)
        val view = inflator.inflate(R.layout.each_item, null)

        val image = view.findViewById<CircleImageView>(R.id.profile_image)
        val name = view.findViewById<TextView>(R.id.tVName)
        val lastMsg = view.findViewById<TextView>(R.id.tVLastMsg)
        val lastMsgTime = view.findViewById<TextView>(R.id.tVLastMsgTime)

        image.setImageResource(userArrayList[position].img_Id)
        name.text = userArrayList[position].name
        lastMsg.text = userArrayList[position].lastMsg
        lastMsgTime.text = userArrayList[position].lastMsgTime

        return view
    }
}