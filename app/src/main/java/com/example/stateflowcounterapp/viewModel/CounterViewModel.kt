package com.example.stateflowcounterapp.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CounterViewModel: ViewModel() {

    /*State flow*/
    private val _counterValue: MutableStateFlow<Int> = MutableStateFlow(0)   //MutableStateFlow needs initial value
    var counterValue: StateFlow<Int> =_counterValue

    fun incrementCounter() {
        _counterValue.value++
    }

    fun decrementCounter() {
        _counterValue.value--
    }
}