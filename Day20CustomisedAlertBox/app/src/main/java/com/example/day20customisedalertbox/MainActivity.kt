package com.example.day20customisedalertbox

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.day20customisedalertbox.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var dialog : Dialog
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var myButton = binding.btnClick

        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialogue)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alert_box))

        var buttonGood = dialog.findViewById<Button>(R.id.btnGood)
        var buttonFeed = dialog.findViewById<Button>(R.id.btnFeed)

        buttonGood.setOnClickListener {
            dialog.dismiss()
        }

        buttonFeed.setOnClickListener {

        }

        myButton.setOnClickListener {
            dialog.show()
        }
        

    }
}