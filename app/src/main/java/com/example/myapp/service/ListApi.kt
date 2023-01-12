package com.example.myapp.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ListApi {
    @GET("/list.json")
    fun getList(@Query("limit") limit: String): Call<ListResponse>;
}