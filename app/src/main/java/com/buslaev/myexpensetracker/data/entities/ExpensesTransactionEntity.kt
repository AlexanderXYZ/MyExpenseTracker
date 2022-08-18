package com.buslaev.myexpensetracker.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "expenses_transaction_entity",
)
data class ExpensesTransactionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "expenses_id")
    val id: Long,

    @ColumnInfo(name = "expenses_value")
    val value: Float,

    @ColumnInfo(name = "expenses_category_id")
    val categoryId: Long,

    @ColumnInfo(name = "expenses_date")
    val date: Date
)
