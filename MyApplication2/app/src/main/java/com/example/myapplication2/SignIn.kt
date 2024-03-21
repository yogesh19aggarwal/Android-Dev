package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication2.databinding.ActivitySignInBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignIn : AppCompatActivity() {
    lateinit var database: DatabaseReference
    lateinit var binding : ActivitySignInBinding
    companion object{
        const val KEY1 = "com.example.myapplication2.SignIn.name"
        const val KEY2 = "com.example.myapplication2.SignIn.email"
        const val KEY3 = "com.example.myapplication2.SignIn.username"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignInBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val etUserName = binding.etSigninUserName
        val etPass = binding.etSigninPassword

        val btnSignIn = binding.btnSignIn
        val signUpCont = binding.textDidnt

        signUpCont.setOnClickListener {
            val intent  = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        btnSignIn.setOnClickListener {
            val userName = etUserName.text.toString()
            val pass = etPass.text.toString()

            if(userName.isEmpty() || pass.isEmpty()){
                if(userName.isEmpty()){
                    binding.textInputLayout1.helperText = "*Required"
                    binding.textInputLayout1.setHelperTextColor(getColorStateList(R.color.Red))
                }
                if(pass.isEmpty()){
                    binding.textInputLayout2.helperText = "*Required"
                    binding.textInputLayout2.setHelperTextColor(getColorStateList(R.color.Red))
                }
                Toast.makeText(this, "Cannot be empty", Toast.LENGTH_SHORT).show()
            }
            else{
                readData(userName, pass)
            }
        }

    }

    private fun readData(user: String, pass: String) {

        database = FirebaseDatabase.getInstance().getReference("Users")

        val usernamech = database.child(user)
        val passch = usernamech.child("password").get()

        usernamech.get().addOnSuccessListener{
            if(it.exists()){
                val email = it.child("email").value
                val username = it.child("userName").value
                val name = it.child("name").value
               passch.addOnSuccessListener {
//                    Log.d("TAG", "readData: $it")
                    if(it.value == pass){
                         val intent = Intent(this, HomeActivity::class.java)
                        intent.putExtra(KEY1, name.toString())
                        intent.putExtra(KEY2, email.toString())
                        intent.putExtra(KEY3, username.toString())
                        startActivity(intent)
                    }else{
                        binding.textInputLayout2.helperText = "Password does not match"
                        binding.textInputLayout2.setHelperTextColor(getColorStateList(R.color.Red))
                    }
               }
            }
            else{
                Toast.makeText(this, "User doesn't exist", Toast.LENGTH_SHORT).show()
            }
        }
    }
}