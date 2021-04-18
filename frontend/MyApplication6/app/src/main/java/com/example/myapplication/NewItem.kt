package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class NewItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_item)

        val cat = findViewById<EditText>(R.id.category)
        val ti = findViewById<EditText>(R.id.title)
        val co = findViewById<EditText>(R.id.content)
        val pr = findViewById<EditText>(R.id.price)

        val category = cat.text
        var title = ti.text
        var content = co.text
        var price = pr.text

        val postbutton = findViewById<Button>(R.id.post_button)
        postbutton.setOnClickListener{
            Log.d("tag2", "cat=${category.toString()}")
            // posting to DB
            //
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)

        }




    }
}