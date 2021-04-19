package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val profile_button = findViewById<Button>(R.id.my_profile_button)
        profile_button.setOnClickListener{
            val intent = Intent(this, MyProfile::class.java)
            startActivity(intent)

        }

        val new_item_button = findViewById<Button>(R.id.new_item_button)
        new_item_button.setOnClickListener{
            val intent = Intent(this, NewItem::class.java)
            startActivity(intent)

        }
    }
}