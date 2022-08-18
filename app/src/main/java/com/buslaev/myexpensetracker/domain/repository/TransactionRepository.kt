package com.buslaev.myexpensetracker.domain.repository

import com.buslaev.myexpensetracker.data.dao.TransactionDao
import com.buslaev.myexpensetracker.data.entities.TransactionAndCategory
import com.buslaev.myexpensetracker.data.entities.TransactionEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface TransactionRepository {

    suspend fun insertTransaction(transaction: TransactionEntity)
    suspend fun deleteTransaction(transaction: TransactionEntity)
    suspend fun getAllTransaction(): Flow<List<TransactionAndCategory>>
}

class TransactionRepositoryImpl @Inject constructor(
    private val dao: TransactionDao
) : TransactionRepository {

    override suspend fun insertTransaction(transaction: TransactionEntity) {
        dao.insertTransaction(transaction)
    }

    override suspend fun deleteTransaction(transaction: TransactionEntity) {
        dao.deleteTransaction(transaction)
    }

    override suspend fun getAllTransaction(): Flow<List<TransactionAndCategory>> = flow {
        emit(dao.getAllTransactions())
    }
//    flow {
//        emit(Resource.Loading())
//        try {
//            val data = dao.getAllTransactions()
//            emit(Resource.Success<List<TransactionAndCategory>>(data = data))
//        } catch (e: Exception) {
//            emit(Resource.Error(message = e.message.toString()))
//        }
//    }
}