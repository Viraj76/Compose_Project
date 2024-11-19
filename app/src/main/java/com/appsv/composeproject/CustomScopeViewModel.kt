package com.appsv.composeproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CustomScopeViewModel : ViewModel() {

    private val job = Job()

    private val customScope = CoroutineScope(Dispatchers.IO + job)

    fun loadData() {
        viewModelScope
        // Launch a coroutine in the custom scope
        customScope.launch {
            // Perform background work here
            val data = fetchDataFromNetwork()
            withContext(Dispatchers.Main) {
                // Update UI-related state on the main thread
                println("Data loaded: $data")
            }
        }
    }

    // Simulate a network call
    private suspend fun fetchDataFromNetwork(): String {
        delay(1000) // Simulate delay
        return "Fetched Data"
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
