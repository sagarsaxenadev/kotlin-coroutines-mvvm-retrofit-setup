package com.sagarmvvmcoroutineskotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sagarmvvmcoroutineskotlin.model.AllPost

class AllPostAdapter(val context: Context,private var arraylist: ArrayList<AllPost>) :
    RecyclerView.Adapter<AllPostAdapter.MyViewModel>() {


    inner class MyViewModel(view: View) : RecyclerView.ViewHolder(view) {
        val mTitle = view.findViewById<TextView>(R.id.title)
        val mDetail = view.findViewById<TextView>(R.id.detail)
        val mId = view.findViewById<TextView>(R.id.id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {

        return MyViewModel(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_all_post, parent, false)
        )

    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        holder.apply {
            mTitle.text = arraylist[position].title
            mId.text ="${arraylist[position].id}. "
            mDetail.text = arraylist[position].body
        }

    }

    override fun getItemCount(): Int = arraylist.size


    fun SetDataToAdapter( arraylist: ArrayList<AllPost>){
        this.arraylist=arraylist
        notifyDataSetChanged()

    }
}