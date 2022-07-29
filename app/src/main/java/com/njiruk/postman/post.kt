package com.njiruk.postman

import android.provider.ContactsContract
import retrofit2.http.POST

data class Post(
    var userId:Int,
    var id: Int,
    var title: String,
    var body: String,
)
data class Comment(
    var postId: Int,
    var id: Int,
    var name: String,
    var email: String,
    var Body: String,
)
