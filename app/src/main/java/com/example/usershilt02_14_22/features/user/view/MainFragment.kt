package com.example.usershilt02_14_22.features.user.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.usershilt02_14_22.databinding.FragmentMainBinding
import com.example.usershilt02_14_22.features.user.viewmodel.TodosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment: Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding) {
            postsBtn.setOnClickListener {
                val directions =
                    MainFragmentDirections.actionMainFragmentToPostsFragment()
                findNavController().navigate(directions)
            }
            todosBtn.setOnClickListener {
                val directions =
                    MainFragmentDirections.actionMainFragmentToTodosFragment()
                findNavController().navigate(directions)
            }
            usersBtn.setOnClickListener {
                val directions =
                    MainFragmentDirections.actionMainFragmentToUsersFragment()
                findNavController().navigate(directions)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}