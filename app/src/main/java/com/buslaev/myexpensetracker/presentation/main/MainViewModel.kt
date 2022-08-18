package com.buslaev.myexpensetracker.presentation.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buslaev.myexpensetracker.data.entities.TransactionAndCategory
import com.buslaev.myexpensetracker.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MainState(
    val totalBalance: Float = 0F,
    val totalIncome: Float = 0F,
    val totalExpenses: Float = 0F,
    val list: List<TransactionAndCategory> = emptyList()
)

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: TransactionRepository
) : ViewModel() {

    var state by mutableStateOf(MainState())

    init {
        getAllTransactions()
    }

    private fun getAllTransactions() = viewModelScope.launch(Dispatchers.IO) {
        repository.getAllTransaction().collect { list ->
            if (list.isNotEmpty())
                state = state.copy(
                    list = list
                )
        }
    }
}