@file:Suppress("ClassName")

package com.e.ahmer.bottomnavigation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class productWithApi : AppCompatActivity() {

    //late-init variable myrecyclerview
    lateinit var myrecyclerview : RecyclerView
    //late-init variable myadapter
    lateinit var myadapter : MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_with_api)

        //myrecyclerview variable are defined
        myrecyclerview=findViewById(R.id.myrecycleView)

    //Retrofit code for API
        val retrofit= Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(getProducts::class.java)

        //get API data using the getproductsdata() interface

        val retrofitData = retrofit.getproductsdata()

        //enqueue method code
        retrofitData.enqueue(object : Callback<MyDatas?> {

            override fun onResponse(call: Call<MyDatas?>, response: Response<MyDatas?>) {
                // if api call is a success, then use the data of API and show in your app
                val responseBody = response.body()
                val productList = responseBody?.products!!

                myadapter = MyAdapter(this@productWithApi, productList)
                myrecyclerview.adapter = myadapter
                myrecyclerview.layoutManager = LinearLayoutManager(this@productWithApi)
            }

            override fun onFailure(call: Call<MyDatas?>, t: Throwable) {
                // if api call fails
                Log.d("productWithApi ", "onFailure: " + t.message)
            }
        })
    }

}