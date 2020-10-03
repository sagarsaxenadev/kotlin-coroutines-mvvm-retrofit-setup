package com.sagarmvvmcoroutineskotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sagarmvvmcoroutineskotlin.model.AllPost
import com.sagarmvvmcoroutineskotlin.repositories.AllPostRepository
import kotlinx.coroutines.launch

class AllPostViewModel(val allPostRepository: AllPostRepository) : ViewModel() {

    val mutableLiveData: MutableLiveData<List<AllPost>> = MutableLiveData()

    fun getAllPost() {

        viewModelScope.launch {
            val response = allPostRepository.getAllPost()
            mutableLiveData.value = response

        }
    }


}