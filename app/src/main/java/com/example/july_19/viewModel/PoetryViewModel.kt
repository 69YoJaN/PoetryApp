package com.example.july_19.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.july_19.model.Poetry
import com.example.july_19.repository.Repository
import kotlinx.coroutines.launch

class PoetryViewModel : ViewModel() {
    private val repository = Repository()

    private val _poetry = MutableLiveData<List<Poetry>>()

    val poetry : LiveData<List<Poetry>> get() = _poetry


    fun getPoetry() {
        viewModelScope.launch {
            try {
                _poetry.value = repository.getPoetry()
            } catch (e: Exception) {
                error(e)
            }
        }
    }
}