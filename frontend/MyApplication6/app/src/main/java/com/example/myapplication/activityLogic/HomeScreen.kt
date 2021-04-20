package com.example.myapplication.activityLogic

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*

//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val token = intent.getSerializableExtra("token")

        my_profile_button.setOnClickListener{
            val intent = Intent(this, MyProfile::class.java)
            intent.putExtra("token", token)
            startActivity(intent)
        }

        new_item_button.setOnClickListener{
            val intent = Intent(this, NewItem::class.java)

            Log.d("TOKEN", " " + token)

            startActivity(intent)
        }

    }
}