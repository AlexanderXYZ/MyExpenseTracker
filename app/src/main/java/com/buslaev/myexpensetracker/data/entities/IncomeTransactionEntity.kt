package com.buslaev.myexpensetracker.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "income_transaction_entity",
)
data class IncomeTransactionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "income_id")
    val id: Long,

    @ColumnInfo(name = "income_value")
    val value: Float,

    @ColumnInfo(name = "income_category_id")
    val categoryId: Long,

    @ColumnInfo(name = "income_date")
    val date: Date
)
