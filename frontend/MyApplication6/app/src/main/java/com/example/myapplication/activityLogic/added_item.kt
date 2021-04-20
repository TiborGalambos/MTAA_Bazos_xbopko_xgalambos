package com.example.myapplication.activityLogic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class added_item : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_added_item)
        supportActionBar?.hide()

        val back_button = findViewById<Button>(R.id.back_to_main)
        back_button.setOnClickListener{
            intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
        }
    }
}