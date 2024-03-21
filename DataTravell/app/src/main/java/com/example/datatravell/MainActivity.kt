package com.example.datatravell

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
//import kotlinx.android.synthetic.main.activity_main.btnO
//import kotlinx.android.synthetic.main.activity_main.et1
//import kotlinx.android.synthetic.main.activity_main.et2
//import kotlinx.android.synthetic.main.activity_main.et3
//import kotlinx.android.synthetic.main.activity_main.et4

class MainActivity : AppCompatActivity() {

    // creating key
    companion object{
        const val KEY = "com.example.datatravell.MainActivity.KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnO).setOnClickListener{
            val msg = findViewById<EditText>(R.id.et1).text.toString() + " " + findViewById<EditText>(R.id.et2).text.toString() + " " + findViewById<EditText>(R.id.et3).text.toString() + " " + findViewById<EditText>(R.id.et4).text.toString()

            intent = Intent(this, ShowOrderActivity::class.java)
            intent.putExtra(KEY, msg)
            startActivity(intent)
        }
    }
}