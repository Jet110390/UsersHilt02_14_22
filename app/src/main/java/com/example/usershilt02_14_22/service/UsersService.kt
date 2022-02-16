package com.example.usershilt02_14_22.service

import com.example.usershilt02_14_22.network.models.User
import retrofit2.Response
import retrofit2.http.GET

interface UsersService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}