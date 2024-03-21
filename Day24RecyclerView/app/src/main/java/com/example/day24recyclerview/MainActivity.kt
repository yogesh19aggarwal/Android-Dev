package com.example.day24recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var newsArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = this.findViewById<Toolbar>(androidx.appcompat.R.id.action_bar)
//        supportActionBar?.setDisplayShowHomeEnabled(true)
//        supportActionBar?.setDisplayUseLogoEnabled(true)
//        supportActionBar?.setLogo(R.drawable.ic_launcher_foreground)
//        this.setSupportActionBar(toolbar)

        myRecyclerView = findViewById(R.id.recyclerView)

        val newsImgArray = arrayOf(R.drawable.user1_img, R.drawable.user2_img, R.drawable.user3_img, R.drawable.user4_img,
            R.drawable.user5_img, R.drawable.user6_img, R.drawable.user7_img)

        val newsHeadingArray = arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
            "Largest gathering of Foreign Ministers hosted by any G20 presidency: Foreign Secretary Vinay Kwatra"
        )

        val newsContent = arrayOf(
            getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content)
        )

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for (i in newsImgArray.indices){
            val news = News(newsHeadingArray[i], newsImgArray[i], newsContent[i])
            newsArrayList.add(news)
        }

        var myAdapter = MyAdapter(newsArrayList, this)

        myRecyclerView.adapter = myAdapter
        myAdapter.setItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                val intent = Intent(applicationContext, NewsDetailActivity::class.java)

                intent.putExtra("heading", newsArrayList[position].newsHeading)
                intent.putExtra("imageId", newsArrayList[position].newsImage)
                intent.putExtra("newsContent", newsArrayList[position].newsContent)

                startActivity(intent)
            }
        })
    }
}