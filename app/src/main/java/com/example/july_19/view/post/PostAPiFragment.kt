package com.example.july_19.view.post

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.july_19.databinding.FragmentPostAPiBinding
import com.example.july_19.model.User
import com.example.july_19.viewModel.PoetryViewModel

class PostAPiFragment : Fragment() {
    private lateinit var binding : FragmentPostAPiBinding
    private lateinit var viewModel: PoetryViewModel
    private val error = "ERROR"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostAPiBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onStart() {
        super.onStart()
        getData()
        createNewUser()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[PoetryViewModel::class.java]

    }

    private fun getData() {
        viewModel.userResponse.observe(this) { userResponse ->
            userResponse?.let {
                binding.getName.text = it.name
                binding.getJOb.text = it.job
                binding.getId.text = it.id
                binding.getCreatedAt.text = it.createdAt
            }?: run{
                binding.getName.text = error
                binding.getJOb.text = error
                binding.getId.text = error
                binding.getCreatedAt.text = error
            }
        }
    }
    private fun createNewUser() {
        binding.buttonSubmit.setOnClickListener {
            val name = binding.nameInputTextBox.text.toString().trim()
            val job = binding.jobInputTextBox.text.toString().trim()

            if (name.isNotEmpty() && job.isNotEmpty()) {
                val user = User(name, job)
                viewModel.createUser(user)
            } else {
                binding.textView.text = error
            }
        }
    }

}