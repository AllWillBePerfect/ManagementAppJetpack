package com.example.managementapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _count = MutableLiveData<Int>(5)
    val count: LiveData<Int> = _count

    fun increase() {
        _count.value = _count.value?.plus(1)
    }
}