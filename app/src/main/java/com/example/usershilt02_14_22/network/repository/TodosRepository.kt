package com.example.usershilt02_14_22.network.repository

import android.util.Log
import com.example.usershilt02_14_22.network.models.Todo
import com.example.usershilt02_14_22.service.TodosService
import javax.inject.Inject

class TodosRepository @Inject constructor(
    private val todosService: TodosService
) {
    suspend fun getTodos(): List<Todo>? {
        return try {
            val response = todosService.getTodos()
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