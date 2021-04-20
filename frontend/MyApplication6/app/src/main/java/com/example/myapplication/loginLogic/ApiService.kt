package com.example.myapplication.loginLogic


import com.example.myapplication.models.ItemResponse
import com.example.myapplication.models.LoginResponse
import com.example.myapplication.models.RegisterResponse
import com.example.myapplication.models.User
import retrofit2.Call
import retrofit2.http.*


interface APIservice {

    @FormUrlEncoded
    @POST("user/login/")
    fun login(
        @Field("username") username:String,
        @Field("password") password: String
    ):Call<LoginResponse>

    @FormUrlEncoded
    @POST("register/")
    fun register(
        @Field("username") username:String,
        @Field("email") email:String,
        @Field("password") password: String
    ):Call<RegisterResponse>


    @GET("api/user/")
    fun userInfo(@Header("Authorization") token: String
    ):Call<User>

    @POST("user/logout/")
    fun logOut(@Header("Authorization") token: String
    ):Call<User>


    @FormUrlEncoded
    @POST("item/")
    fun postItem(
        @Header("Authorization") token: String,
        @Field("category") category:String,
        @Field("title") title:String,
        @Field("content") content: String,
        @Field("price") price:Int,
        @Field("address") address:String,
       // @Field("photo") photo: String?
    ):Call<ItemResponse>


}