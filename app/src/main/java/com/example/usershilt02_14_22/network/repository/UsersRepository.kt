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
//    fun getUsers() = flow {
//        emit(Resource.Loading)
//        val response = usersService.getUsers()
//        val resource = try {
//            if (response.isSuccessful && response.body() != null) {
//                Resource.Success(response.body()!!)
//            } else {
//                Resource.Error("Api call was not successful.")
//            }
//        } catch (ex: Exception) {
//            Resource.Error(ex.message ?: "Unexpected error")
//        }
//        emit(resource)
//    }
    suspend fun getUsers(): List<User>? {
        return try {
            val response = usersService.getUsers()
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