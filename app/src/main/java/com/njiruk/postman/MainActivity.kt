package com.njiruk.postman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.POST

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchPosts()
    }
    fun fetchPosts (){
        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPosts()
        request.enqueue(object :Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
               if (response.isSuccessful){
                   var posts = response.body()
                   Toast.makeText(baseContext, "fetched ${posts!!.size}posts",Toast.LENGTH_LONG)
               }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

        })
    }
}