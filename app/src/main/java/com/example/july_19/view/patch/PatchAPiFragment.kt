package com.example.july_19.view.patch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.july_19.databinding.FragmentPatchAPiBinding

class PatchAPiFragment : Fragment() {
    private lateinit var binding : FragmentPatchAPiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPatchAPiBinding.inflate(inflater, container, false)
        return binding.root
    }
}