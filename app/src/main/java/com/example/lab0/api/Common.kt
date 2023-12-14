package com.example.lab0.api

object Common {

    val retrofitService: ApiService
        get() = RetrofitHelper.getClient("http://192.168.0.101:8080/").create(ApiService::class.java)
}