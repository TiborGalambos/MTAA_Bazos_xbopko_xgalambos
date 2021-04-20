package com.example.myapplication.activityLogic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_my_profile.*


class MyProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)
        supportActionBar?.hide()

        //val token = intent.getSerializableExtra("token")


        logout.setOnClickListener{
                        startActivity(intent)
        }

        show_my_items.setOnClickListener{
//            intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
        }
    }
}