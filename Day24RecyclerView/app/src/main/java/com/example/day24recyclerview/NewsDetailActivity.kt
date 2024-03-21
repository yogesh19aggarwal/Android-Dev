package com.example.day24recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val heading = intent.getStringExtra("heading")
        val newsContent = intent.getStringExtra("newsContent")
        val imageId = intent.getIntExtra("imageId", R.drawable.user1_img)

        val img = findViewById<ImageView>(R.id.newsImage)
        val tVHeading = findViewById<TextView>(R.id.newsHeading)
        val content = findViewById<TextView>(R.id.newsContent)

        img.setImageResource(imageId)
        tVHeading.text = heading
        content.text = newsContent
    }
}