package com.example.e_commerce

import retrofit2.Call
import retrofit2.http.GET

interface ApiBaseInterface {

    @GET("products")
    fun getProductsListApi(): Call<ArrayList<ProductDetail>>

    @GET("products/categories")
    fun getCategoriesApi() : Call<ArrayList<String>>



}