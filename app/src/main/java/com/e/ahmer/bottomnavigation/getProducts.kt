package com.e.ahmer.bottomnavigation

import retrofit2.Call
import retrofit2.http.GET

@Suppress("ClassName")
interface getProducts {

    //get API products
    @GET("products")
    //interface func. code with call MYData class
    fun getproductsdata(): Call<MyDatas>
}