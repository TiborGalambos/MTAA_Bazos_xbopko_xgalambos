package com.example.myapplication.activityLogic

import APIclient
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.loginLogic.SessionManager
import com.example.myapplication.models.ItemList
import com.example.myapplication.models.ItemListAdapter
import kotlinx.android.synthetic.main.activity_items.*
import kotlinx.android.synthetic.main.row.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Items : AppCompatActivity() {

    lateinit var sessionManager: SessionManager
    private lateinit var apiClient: APIclient

    @ExperimentalMultiplatform
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        supportActionBar?.hide()

        apiClient = APIclient()
        sessionManager = SessionManager(this)


        apiClient.getApiService(this).showAllItems(token = "Token ${sessionManager.fetchAuthToken()}").
        enqueue(object : Callback<ItemList> {
            override fun onFailure(call: Call<ItemList>, t: Throwable) {
                //println("[HomeFragment] FAILURE. Is the server running? " + t.stackTrace)
            }

            // @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<ItemList>, response: Response<ItemList>) {
                //println("[HomeFragment] SUCCESS. Token ${sessionManager.fetchAuthToken()}. Response: " + response.toString())

                val itemList = response.body()
                Log.d("SIZE", " " + itemList?.items?.size)
                //itemList?.items?.size

                val authors = arrayOfNulls<String>(itemList!!.items!!.size)
                for (i: Int in itemList!!.items!!.indices)
                    authors[i] = (itemList!!.items[i]!!.author_name)

                val categories = arrayOfNulls<String>(itemList!!.items!!.size)
                for (i: Int in itemList.items.indices)
                    categories[i] = (itemList.items[i].category).toString()

                val titles = arrayOfNulls<String>(itemList!!.items!!.size)
                for (i: Int in itemList.items.indices)
                    titles[i] = (itemList.items[i].title).toString()

                val contents = arrayOfNulls<String>(itemList!!.items!!.size)
                for (i: Int in itemList.items.indices)
                    contents[i] = (itemList.items[i].content.toString())

                val prices = arrayOfNulls<String>(itemList!!.items!!.size)
                for (i: Int in itemList.items.indices)
                    prices[i] = (itemList.items[i].price).toString()

                val photos = arrayOfNulls<String>(itemList!!.items!!.size)
                for (i: Int in itemList.items.indices)
                    photos[i] = itemList.items[i].photo

                val ids = arrayOfNulls<String>(itemList!!.items!!.size)
                for (i: Int in itemList.items.indices)
                    ids[i] = itemList.items[i].photo

                val adapter = ItemListAdapter(
                    this@Items,
                    authors,
                    categories,
                    titles,
                    contents,
                    prices,
                    photos,
                    ids
                )

                list_id.adapter = adapter

            }
        })






    }
}