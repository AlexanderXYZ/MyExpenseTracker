package com.buslaev.myexpensetracker.data.dao

import androidx.room.*
import com.buslaev.myexpensetracker.data.entities.TransactionAndCategory
import com.buslaev.myexpensetracker.data.entities.TransactionEntity

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: TransactionEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTransaction(transaction: TransactionEntity)

    @Delete
    suspend fun deleteTransaction(transaction: TransactionEntity)

    @Transaction
    @Query("SELECT * FROM transaction_table")
    suspend fun getAllTransactions(): List<TransactionAndCategory>

    @Transaction
    @Query("SELECT * FROM transaction_table WHERE is_income = 1")
    suspend fun getIncomeTransactions(): List<TransactionAndCategory>

    @Transaction
    @Query("SELECT * FROM transaction_table WHERE is_income = 0")
    suspend fun getExpensesTransactions(): List<TransactionAndCategory>

    @Query("SELECT * FROM transaction_table WHERE date > :startDate AND date < :endDate")
    suspend fun getTransactionByPeriod(
        startDate: Long,
        endDate: Long
    ): List<TransactionAndCategory>
}