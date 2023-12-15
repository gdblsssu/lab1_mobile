package com.example.lab0.api

object Common {

    val retrofitService: ApiService
        get() = RetrofitHelper.getClient("").create(ApiService::class.java)
}
