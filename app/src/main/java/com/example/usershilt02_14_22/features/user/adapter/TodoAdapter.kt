package com.example.usershilt02_14_22.features.user.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usershilt02_14_22.databinding.TodoItemBinding
import com.example.usershilt02_14_22.network.models.Todo

class TodoAdapter (private val todoList: List<Todo>
): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TodoItemBinding.inflate(inflater, parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todoList[position])
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    class TodoViewHolder(private val binding: TodoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(todo:Todo) {
            with(binding) {
                todoTv.text =
                    "UserId: ${todo.userId}\nTodoId: ${todo.id} \nTask: ${todo.title}\nStatus: ${if (todo.completed) "Completed" else "Incomplete"}"
            }
        }
    }
}