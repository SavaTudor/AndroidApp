package com.example.myapp.service

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RestApi {
    private val listApi : ListApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://random-data-api.com/api/v2/users?")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        listApi = retrofit.create(ListApi::class.java)
    }

    fun getList(limit: String): Call<ListResponse>{
        return listApi.getList(limit)
    }
}