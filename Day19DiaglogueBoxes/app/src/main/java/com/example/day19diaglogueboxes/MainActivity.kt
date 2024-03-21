package com.example.day19diaglogueboxes

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.day19diaglogueboxes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you Sure?")
            builder1.setMessage("Do you want to close the App")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)

            builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                // what action should be performed if yes is clicked
                finish()
            })
            builder1.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                // what action should be performed if no is clicked
            })

            builder1.show()
        }

        binding.btn2.setOnClickListener {

            val options = arrayOf("Gulab Jamun", "Rasmalai", "Kaju Katli")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is your Fav Sweet?")
            builder2.setSingleChoiceItems(options, 0, DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->

            })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which ->
                // what action should be performed if no is clicked
            })
            builder2.show()
        }

        binding.btn3.setOnClickListener {
            val options = arrayOf("Gulab Jamun", "Rasmalai", "Kaju Katli")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Which is your Fav Sweet?")
            builder3.setMultiChoiceItems(options, null, DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder3.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->

            })
            builder3.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which ->
                // what action should be performed if no is clicked
            })
            builder3.show()
        }
    }
}