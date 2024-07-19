package com.example.july_19.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.july_19.adapters.PoetryAdapter
import com.example.july_19.databinding.ActivityMainBinding
import com.example.july_19.viewModel.PoetryViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : PoetryViewModel
    private lateinit var poetryAdapter: PoetryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[PoetryViewModel::class.java]



    }

    override fun onStart() {
        setAdapter()
        getPoetry()
        viewModel.getPoetry()
        super.onStart()
    }

    private fun setAdapter() {
        binding.poetryRecyclerView.layoutManager = LinearLayoutManager(this)
        poetryAdapter = PoetryAdapter(emptyList())
        binding.poetryRecyclerView.adapter = poetryAdapter
    }

    private fun getPoetry() {
        viewModel.poetry.observe(this) { poetry ->
            if (poetry.isNotEmpty()) {
                poetryAdapter.setPoetry(poetry)
                binding.Loader.visibility = View.GONE
            } else {

            }
        }
    }
}
