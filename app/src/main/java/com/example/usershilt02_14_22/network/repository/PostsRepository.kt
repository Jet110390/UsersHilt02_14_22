package com.example.usershilt02_14_22.network.repository

import android.util.Log
import com.example.usershilt02_14_22.network.models.Post
import com.example.usershilt02_14_22.service.PostsService
import javax.inject.Inject

class PostsRepository @Inject constructor(
    private val postsService: PostsService
) {
    suspend fun getPosts(): List<Post>? {
        return try {
            val response = postsService.getPosts()
            Log.d("response","$response")
            if (response.isSuccessful) {
                Log.d("success","${response.body()}")
                response.body()
            } else {
                Log.d("error","${response.errorBody()}")
                emptyList()
            }
        } catch (ex: Exception) {
            Log.d("response","${ex.cause}")
            emptyList()
        }
    }

}