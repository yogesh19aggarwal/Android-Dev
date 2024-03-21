package com.example.interactionapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDark = findViewById<Button>(R.id.btnDark)
        val lightButton = findViewById<Button>(R.id.btnLight)
        val layout = findViewById<LinearLayout>(R.id.LinearLayout)

        lightButton.setOnClickListener {
//            change to light mode
            layout.setBackgroundResource(R.color.yellow)
        }
        buttonDark.setOnClickListener{
//            change to dark mode
            layout.setBackgroundResource(R.color.black)
        }
    }
}