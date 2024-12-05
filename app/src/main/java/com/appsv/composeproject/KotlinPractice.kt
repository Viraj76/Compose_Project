package com.appsv.composeproject

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val sourceFlow: Flow<Int> = flowOf(1, 2, 3, 4, 5)

    val transformedFlow: Flow<Int> = sourceFlow.transform { number ->
        number * 2
    }

    transformedFlow.collect { value ->
        println(value)
    }
}