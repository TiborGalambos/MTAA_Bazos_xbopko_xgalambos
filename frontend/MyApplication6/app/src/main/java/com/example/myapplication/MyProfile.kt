package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MyProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)
        supportActionBar?.hide()


        val logout_button = findViewById<Button>(R.id.logout)
        logout_button.setOnClickListener{
//            intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
        }

        val my_items_button = findViewById<Button>(R.id.show_my_items)
        my_items_button.setOnClickListener{
//            intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
        }

    }
}