package com.example.myapplication.loginLogic


import android.net.Uri
import com.example.myapplication.models.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.*
import java.io.File


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


    @Multipart
    @POST("item/")
    fun postItem(
            @Header("Authorization") token: String,
            @Part("category") category:String,
            @Part("title") title:String,
            @Part("content") content: String,
            @Part("price") price:Int,
            @Part("address") address:String,
            //@Part("photo") photo:MultipartBody.Part,
            @Part photo: MultipartBody.Part
    ):Call<ItemResponse>


    @ExperimentalMultiplatform
    @GET("item/all/")
    fun showAllItems(
        @Header("Authorization") token: String
    ):Call<ItemList>


}