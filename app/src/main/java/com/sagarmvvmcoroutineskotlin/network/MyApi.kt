package com.sagarmvvmcoroutineskotlin.network

import com.sagarmvvmcoroutineskotlin.model.AllPost
import retrofit2.http.GET

interface MyApi {

    @GET("posts")

    suspend fun getAllPost(): List<AllPost>

}