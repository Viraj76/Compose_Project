package com.appsv.composeproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
        customScope.launch {
            val data = fetchDataFromNetwork()
            withContext(Dispatchers.Main) {
                println("Data loaded: $data")
            }
        }
    }

    private suspend fun fetchDataFromNetwork(): String {
        delay(1000)
        return "Fetched Data"
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
