package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val newbutton = findViewById<Button>(R.id.AddNewItemButton)
        newbutton.setOnClickListener{
            val intent = Intent(this, NewItem::class.java)
            startActivity(intent)

        }
    }
}