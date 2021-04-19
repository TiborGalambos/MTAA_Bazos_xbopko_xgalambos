package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class NewItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_item)
        supportActionBar?.hide()

        val cat_list = resources.getStringArray(R.array.Categories)

        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, cat_list
            )
            spinner.adapter = adapter

//        spinner.onItemSelectedListener = object :
//            AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>,
//                                        view: View, position: Int, id: Long) {
//                Toast.makeText(this@NewItem,
//                    getString(R.string.selected_item) + " " +
//                            "" + cat_list[position], Toast.LENGTH_SHORT).show()
//            }

//        val cat = findViewById<EditText>(R.id.category)
            val ti = findViewById<EditText>(R.id.title)
            val co = findViewById<EditText>(R.id.content)
            val pr = findViewById<EditText>(R.id.price)

//        val category = cat.text
            val title = ti.text
            val content = co.text
            val price = pr.text

            val postbutton = findViewById<Button>(R.id.post_button)
            postbutton.setOnClickListener {
                Log.d("tag2", "cat=${title.toString()}")
                // posting to DB
                //
            val intent = Intent(this, added_item::class.java)
            startActivity(intent)

            }


        }
    }
}