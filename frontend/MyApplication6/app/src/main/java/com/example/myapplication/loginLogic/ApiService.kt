package com.example.myapplication.loginLogic


import com.example.myapplication.models.ItemResponse
import com.example.myapplication.models.LoginResponse
import retrofit2.Call
import retrofit2.http.*


interface APIservice {

    @FormUrlEncoded
    @POST("user/login/")
    fun login(
        @Field("username") username:String,
        @Field("password") password: String
    ):Call<LoginResponse>

    @ExperimentalMultiplatform
    @GET("item/26/")
    fun getSpecificItem():Call<ItemResponse>


}