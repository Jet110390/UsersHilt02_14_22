package com.example.usershilt02_14_22.features.user.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usershilt02_14_22.network.models.Todo
import com.example.usershilt02_14_22.network.repository.TodosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodosViewModel @Inject constructor(
    private val todosRepository: TodosRepository
): ViewModel() {

    private val _todos: MutableLiveData<List<Todo>?> = MutableLiveData()
    val todos: LiveData<List<Todo>?> get() = _todos

    init {
        getTodos()
    }

    private fun getTodos() {
        viewModelScope.launch {

            val response =todosRepository.getTodos()
            _todos.postValue(response)

        }
    }

}