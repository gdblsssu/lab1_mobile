package com.example.lab0.api

object Common {

    val retrofitService: ApiService
        get() = RetrofitHelper.getClient("http://192.168.0.199:8080/").create(ApiService::class.java)
}