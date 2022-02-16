package com.example.usershilt02_14_22.network.repository

import android.util.Log
import com.example.usershilt02_14_22.network.models.User
import com.example.usershilt02_14_22.service.UsersService
import com.example.usershilt02_14_22.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UsersRepository @Inject constructor(
private val usersService: UsersService
) {
    suspend fun getUsers(): List<User>? {
        return try {
            val response = usersService.getUsers()
            if (response.isSuccessful) {
                response.body()
            } else {
                Log.d("error","${response.errorBody()}")
                emptyList()
            }
        } catch (ex: Exception) {
            emptyList()
        }
    }

}