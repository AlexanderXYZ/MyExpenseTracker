package com.buslaev.myexpensetracker.presentation.transaction

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buslaev.myexpensetracker.data.entities.CategoryEntity
import com.buslaev.myexpensetracker.domain.repository.CategoryRepository
import com.buslaev.myexpensetracker.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

data class TransactionState(
    val list: List<CategoryEntity> = emptyList()
)

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository,
    private val categoryRepository: CategoryRepository
) : ViewModel() {

    var state by mutableStateOf(TransactionState())

    init {

    }

    fun getCategories() = viewModelScope.launch(Dispatchers.IO) {
        categoryRepository.getCategories().collect {
            if (it.isNotEmpty())
                state = state.copy(list = it)
        }
    }
}