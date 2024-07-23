package com.example.july_19.view.get

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.july_19.adapters.PoetryAdapter
import com.example.july_19.databinding.FragmentGetAPiBinding
import com.example.july_19.viewModel.PoetryViewModel

class GetAPiFragment : Fragment() {
    private lateinit var binding : FragmentGetAPiBinding
    private lateinit var viewModel: PoetryViewModel
    private lateinit var poetryAdapter: PoetryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGetAPiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        setAdapter()
        getPoetry()
        viewModel.getPoetry()
        super.onStart()
    }

    private fun getPoetry() {
        viewModel.poetry.observe(this) { poetry ->
            if (poetry.isNotEmpty()) {
                poetryAdapter.setPoetry(poetry)
                binding.Loader.visibility = View.GONE
            } else {
                //
            }
        }
    }

    private fun setAdapter() {
        binding.poetryRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        poetryAdapter = PoetryAdapter(emptyList())
        binding.poetryRecyclerView.adapter = poetryAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[PoetryViewModel::class.java]
    }
}