package com.example.july_19.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.july_19.databinding.ActivityMainBinding
import com.example.july_19.viewModel.PoetryViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : PoetryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(PoetryViewModel::class.java)


        viewModel.poetry.observe(this, Observer { poetry ->
            if (poetry.isNotEmpty()) {
                val getPoetry = poetry[0]
                binding.title.text = getPoetry.title
            }
        })

        viewModel.getPoetry()
    }
}
