package com.buslaev.myexpensetracker.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.buslaev.myexpensetracker.data.dao.CategoryDao
import com.buslaev.myexpensetracker.data.dao.ExpensesDao
import com.buslaev.myexpensetracker.data.dao.IncomeDao
import com.buslaev.myexpensetracker.data.entities.CategoryEntity
import com.buslaev.myexpensetracker.data.entities.ExpensesTransactionEntity
import com.buslaev.myexpensetracker.data.entities.IncomeTransactionEntity

@Database(
    entities = [
        CategoryEntity::class,
        IncomeTransactionEntity::class,
        ExpensesTransactionEntity::class
    ], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun incomeDao(): IncomeDao
    abstract fun expensesDao(): ExpensesDao
}