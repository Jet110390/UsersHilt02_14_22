package com.example.usershilt02_14_22.features.user.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usershilt02_14_22.network.models.Post
import com.example.usershilt02_14_22.network.models.User
import com.example.usershilt02_14_22.network.repository.PostsRepository
import com.example.usershilt02_14_22.network.repository.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val postsRepository: PostsRepository
): ViewModel() {

    private val _posts: MutableLiveData<List<Post>?> = MutableLiveData()
    val posts: LiveData<List<Post>?> get() = _posts

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {

            val response =postsRepository.getPosts()
            _posts.postValue(response)

        }
    }

}