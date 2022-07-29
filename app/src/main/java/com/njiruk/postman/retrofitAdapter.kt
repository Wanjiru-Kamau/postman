package com.njiruk.postman

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit

class retrofitAdapter (
    var context: Context,var postList: List<Post>
):RecyclerView.Adapter<RetrofitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var bindingView= RetrofitListPostsBinding.inflate(LayoutInflater.from(context), parent,false)
        return RetrofitViewHolder(bindingView)

    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentItem = postList.get(position)

        with(holder.bindingView) {
            tvPostId.text = currentItem.id.toString()
            tvUserId.text = currentItem.userId.toString()
            tvTitleId.text = currentItem.title
            tvBodyId.text = currentItem.body
        }

    }

    override fun getItemCount(): Int {
        return postList.size

    }

}
class RetrofitViewHolder(var bindingView: RetrofitListPostsBinding) :
        RecyclerView.ViewHolder(bindingView.root){

        }