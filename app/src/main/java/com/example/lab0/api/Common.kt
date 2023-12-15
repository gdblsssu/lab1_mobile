package com.example.lab0.api

object Common {

    val retrofitService: ApiService
        get() = RetrofitHelper.getClient("ip").create(ApiService::class.java)
}