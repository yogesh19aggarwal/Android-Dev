package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = intent.getStringExtra(SignIn.KEY1)
        val email = intent.getStringExtra(SignIn.KEY2)
        val username = intent.getStringExtra(SignIn.KEY3)

        val textView = binding.welcTextHome

        textView.text = "Welcome $name"
    }
}