package com.example.usershilt02_14_22.features.user.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usershilt02_14_22.databinding.FragmentUserBinding
import com.example.usershilt02_14_22.features.user.adapter.PostAdapter
import com.example.usershilt02_14_22.features.user.viewmodel.PostsViewModel

class PostsFragment: Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val binding: FragmentUserBinding get() = _binding!!

    private val viewModel: PostsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding) {
            viewModel.posts.observe(viewLifecycleOwner) {posts->
                userRv.apply {
                    adapter = posts?.let { PostAdapter(it) }
                    layoutManager =
                        LinearLayoutManager(requireContext())
                }
            }
            backBtn.setOnClickListener {
                val directions =
                    PostsFragmentDirections.actionPostFragmentToMainFragment()
                findNavController().navigate(directions)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}