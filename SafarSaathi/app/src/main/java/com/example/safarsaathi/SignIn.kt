package com.example.safarsaathi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.safarsaathi.databinding.ActivityMainBinding
import com.example.safarsaathi.databinding.ActivitySignInBinding

class SignIn : AppCompatActivity() {
    lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignInBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}