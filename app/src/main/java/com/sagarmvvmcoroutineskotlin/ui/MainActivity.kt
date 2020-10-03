package com.sagarmvvmcoroutineskotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sagarmvvmcoroutineskotlin.adapter.AllPostAdapter
import com.sagarmvvmcoroutineskotlin.R
import com.sagarmvvmcoroutineskotlin.factory.AllPostViewmodelFactory
import com.sagarmvvmcoroutineskotlin.model.AllPost
import com.sagarmvvmcoroutineskotlin.repositories.AllPostRepository
import com.sagarmvvmcoroutineskotlin.viewmodel.AllPostViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var mProgressBar: ProgressBar
    private lateinit var mRcAllPost: RecyclerView
    private lateinit var allPostAdapter: AllPostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intiView()
        mProgressBar.visibility = View.VISIBLE
        mRcAllPost.visibility = View.GONE
        val allPostRepository = AllPostRepository()
        val viewmodelFactory = AllPostViewmodelFactory(allPostRepository)

        val allPostViewModel =
            ViewModelProvider(this, viewmodelFactory)[AllPostViewModel::class.java]

        allPostViewModel.getAllPost()
        allPostViewModel.mutableLiveData.observe(this, Observer {
//            Log.d( "Response : ", it.toString())
            allPostAdapter.SetDataToAdapter(it as ArrayList<AllPost>)
            mProgressBar.visibility = View.GONE
            mRcAllPost.visibility = View.VISIBLE

        })


    }

    private fun intiView() {
        mRcAllPost = findViewById<RecyclerView>(R.id.rv_all_post)
        mProgressBar = findViewById<ProgressBar>(R.id.progress_bar)
        allPostAdapter = AllPostAdapter(this@MainActivity, ArrayList())

        mRcAllPost.apply {
            setHasFixedSize(true)
           layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=allPostAdapter
        }


    }
}