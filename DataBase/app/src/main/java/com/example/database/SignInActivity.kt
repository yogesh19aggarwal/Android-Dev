package com.example.database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class SignInActivity : AppCompatActivity() {

    private lateinit var fdatabase : DatabaseReference
    companion object{
        const val KEY1 = "com.example.database.SignInActivity.mail"
        const val KEY2 = "com.example.database.SignInActivity.name"
        const val KEY3 = "com.example.database.SignInActivity.id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signUpcont = findViewById<TextView>(R.id.tSignupCont)
        signUpcont.setOnClickListener {
            intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        val signInButton = findViewById<Button>(R.id.btnSignIn)
        val etUserN = findViewById<TextInputEditText>(R.id.UserN)
        val etPass = findViewById<TextInputEditText>(R.id.etPassw)

        signInButton.setOnClickListener {
            val userNameString = etUserN.text.toString()
            if(userNameString.isNotEmpty()){
                readData(userNameString)
            } else{
                Toast.makeText(this, "Please enter the UserName", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(UserName: String) {
        fdatabase = FirebaseDatabase.getInstance().getReference("Users")

        fdatabase.child(UserName).get().addOnSuccessListener {

            if(it.exists()){
                val email = it.child("email").value
                val name = it.child("name").value
                val userId = it.child("id").value

                val intentWelcome = Intent(this, WelcomeActivity::class.java)
                intentWelcome.putExtra(KEY1, email.toString())
                intentWelcome.putExtra(KEY2, name.toString())
                intentWelcome.putExtra(KEY3, userId.toString())
                startActivity(intentWelcome)
            }else{
                Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Failed to fetch data", Toast.LENGTH_SHORT).show()
        }
    }
}