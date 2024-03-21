package com.example.database

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class SignUpActivity : AppCompatActivity() {

    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signBtn = findViewById<Button>(R.id.btnSignUp)
        val mailA = findViewById<TextInputEditText>(R.id.etmail)
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val userPass = findViewById<TextInputEditText>(R.id.etPass)
        val userName = findViewById<TextInputEditText>(R.id.etuserN)

        signBtn.setOnClickListener {

            val name = etName.text.toString()
            val mail = mailA.text.toString()
            val userId = userName.text.toString()
            val password = userPass.text.toString()

            if (name.isEmpty() || mail.isEmpty() || userId.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                val user = User(name, mail, password, userId)
                database = FirebaseDatabase.getInstance().getReference("Users")

                database.child(userId).setValue(user).addOnSuccessListener {
                    etName.text?.clear()
                    mailA.text?.clear()
                    userPass.text?.clear()
                    userName.text?.clear()

                    Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val alSignup = findViewById<TextView>(R.id.alSign)
        alSignup.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}