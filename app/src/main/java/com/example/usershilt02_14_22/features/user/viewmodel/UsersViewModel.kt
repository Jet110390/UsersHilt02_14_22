package com.example.usershilt02_14_22.features.user.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usershilt02_14_22.features.user.adapter.UserAdapter
import com.example.usershilt02_14_22.network.models.User
import com.example.usershilt02_14_22.network.repository.UsersRepository
import com.example.usershilt02_14_22.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val usersRepository: UsersRepository
): ViewModel() {

    private val _users: MutableLiveData<List<User>?> = MutableLiveData()
    val users: LiveData<List<User>?> get() = _users

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {

            val response =usersRepository.getUsers()
                _users.postValue(response)

        }
    }

}