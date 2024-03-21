package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication2.databinding.ActivitySignUpBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val etName = binding.etSignUpNAme
        val etEmail = binding.etSignUpEmail
        val etPass = binding.etSignUpPass
        val etUserName = binding.etSignUpUser
        val btnSignUp = binding.btnSignUp
        val AlreadySignin = binding.SignUpAlreadySignIn

        btnSignUp.setOnClickListener {

            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val pass = etPass.text.toString()
            val userName = etUserName.text.toString()

            if (name.isEmpty() || email.isEmpty() ||  pass.isEmpty()) {
                if(name.isEmpty()){
                    binding.TextInputLayer1.helperText = "*Required"
                    binding.TextInputLayer1.setHelperTextColor(getColorStateList(R.color.Red))
                }
                if(email.isEmpty()){
                    binding.TextInputLayer2.helperText = "*Required"
                    binding.TextInputLayer2.setHelperTextColor(getColorStateList(R.color.Red))
                }
                if(pass.isEmpty()){
                    binding.TextInputLayer3.helperText = "*Required"
                    binding.TextInputLayer3.setHelperTextColor(getColorStateList(R.color.Red))
                }
                if(userName.isEmpty()){
                    binding.TextInputLayer3.helperText = "*Required"
                    binding.TextInputLayer3.setHelperTextColor(getColorStateList(R.color.Red))
                }
                Toast.makeText(this, "Cannot be Empty", Toast.LENGTH_SHORT).show()
            }
            else{
                val user = UserData(name, email, userName, pass)
                database = FirebaseDatabase.getInstance().getReference("Users")
                database.child(userName).setValue(user).addOnSuccessListener {
                    etName.text?.clear()
                    etEmail.text?.clear()
                    etPass.text?.clear()
                    etUserName.text?.clear()
                    Toast.makeText(this, "User registered", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, SignIn::class.java)
                    startActivity(intent)
                }.addOnFailureListener{
                    Toast.makeText(this, "User cannot register, Please try Again", Toast.LENGTH_SHORT).show()
                }
            }
        }

        AlreadySignin.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }
    }
}