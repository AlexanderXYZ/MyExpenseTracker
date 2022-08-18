package com.buslaev.myexpensetracker.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.buslaev.myexpensetracker.data.dao.CategoryDao
import com.buslaev.myexpensetracker.data.dao.TransactionDao
import com.buslaev.myexpensetracker.data.entities.CategoryEntity
import com.buslaev.myexpensetracker.data.entities.TransactionEntity

@Database(
    entities = [
        CategoryEntity::class,
        TransactionEntity::class
    ], version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun transactionDao(): TransactionDao
}