package com.sagarmvvmcoroutineskotlin.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sagarmvvmcoroutineskotlin.AllPostRepository
import com.sagarmvvmcoroutineskotlin.AllPostViewModel

class AllPostViewmodelFactory(val allPostRepository: AllPostRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AllPostViewModel(allPostRepository) as T
    }
}