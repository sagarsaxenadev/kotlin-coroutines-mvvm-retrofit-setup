package com.sagarmvvmcoroutineskotlin.repositories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sagarmvvmcoroutineskotlin.network.RetrofitBuilder

class AllPostRepository{

    // call the api in repository
    suspend fun getAllPost() = RetrofitBuilder.api.getAllPost()


}