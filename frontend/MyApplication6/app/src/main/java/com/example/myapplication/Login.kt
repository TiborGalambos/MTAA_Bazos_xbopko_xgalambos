package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        val user = findViewById<EditText>(R.id.username)
        val pass = findViewById<EditText>(R.id.password)
        val log_b = findViewById<Button>(R.id.login_button)

//        val category = cat.text
        val username = user.text
        val password = pass.text

        log_b.setOnClickListener{
            //login
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)



        }


    }
}