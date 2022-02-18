package com.example.usershilt02_14_22.service

import com.example.usershilt02_14_22.network.models.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostsService {

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}