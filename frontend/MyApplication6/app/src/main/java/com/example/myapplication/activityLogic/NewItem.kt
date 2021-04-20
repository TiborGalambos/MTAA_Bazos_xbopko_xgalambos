package com.example.myapplication.activityLogic

import APIclient
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.myapplication.R
import com.example.myapplication.loginLogic.SessionManager
import com.example.myapplication.models.ItemResponse
import com.example.myapplication.models.User
import kotlinx.android.synthetic.main.activity_my_profile.*
import kotlinx.android.synthetic.main.activity_new_item.*
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewItem : AppCompatActivity() {

    lateinit var sessionManager: SessionManager
    private lateinit var apiClient: APIclient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_item)
        supportActionBar?.hide()

        apiClient = APIclient()
        sessionManager = SessionManager(this)

        val cat_list = resources.getStringArray(R.array.Categories)
        var pos:Int = 1
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, cat_list
            )
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                )   {
                    pos = position
//                    Toast.makeText(this@NewItem, getString(R.string.selected_item) + " " + "" + cat_list[position], Toast.LENGTH_SHORT ).show()
                    }
                    override fun onNothingSelected(p0: AdapterView<*>?) {
                    }
                }
        }

        post_button.setOnClickListener{
//            Toast.makeText(applicationContext,cat_list[pos], Toast.LENGTH_SHORT).show()
//
            val category = cat_list[pos].toString().trim()
            val title = title_text.text.toString().trim()
            val content = content_text.text.toString().trim()
            val address = address_text.text.toString().trim()
            val price = price_text.text.toString().trim()

            if (title.isEmpty()) {
                title_text.error = "Title required"
                title_text.requestFocus()
                return@setOnClickListener
            }

            if (content.isEmpty()) {
                content_text.error = "Content required"
                content_text.requestFocus()
                return@setOnClickListener
            }

            if (address.isEmpty()) {
                address_text.error = "Address required"
                address_text.requestFocus()
                return@setOnClickListener
            }

            if (price.isEmpty()) {
                price_text.error = "Price required"
                price_text.requestFocus()
                return@setOnClickListener
            }

            intent = Intent(this, added_item::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            apiClient.getApiService(this).postItem(category = category, title = title, content = content, price = price.toInt(), address = address, token = "Token ${sessionManager.fetchAuthToken()}")
                .enqueue(object : Callback<ItemResponse> {
                    override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                        Log.d("ERROR", "Response: " + t.message)
                        Toast.makeText(applicationContext, "FAIL", Toast.LENGTH_SHORT).show()
                    }
                    override fun onResponse(call: Call<ItemResponse>, response: Response<ItemResponse>) {
                        Toast.makeText(applicationContext, "SUCCESS", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                })

        }


    }
}
