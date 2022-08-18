package com.buslaev.myexpensetracker.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Transaction entity
 * @property id id of transaction
 * @property value value of transaction
 * @property categoryId id of category
 * @property isIncome true - income, false - expenses
 * @property date date of transaction
 */
@Entity(tableName = "transaction_table")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "transaction_id")
    val id: Long = 0L,

    @ColumnInfo(name = "value")
    val value: Float = 0F,

    @ColumnInfo(name = "category_id")
    val categoryId: Long = 0L,

    @ColumnInfo(name = "is_income")
    val isIncome: Boolean = true,

    @ColumnInfo(name = "date")
    val date: Long = 0L
)
