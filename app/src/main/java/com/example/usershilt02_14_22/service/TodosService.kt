package com.example.usershilt02_14_22.service

import com.example.usershilt02_14_22.network.models.Todo
import retrofit2.Response
import retrofit2.http.GET

interface TodosService {

    @GET("todos")
    suspend fun getTodos(): Response<List<Todo>>
}