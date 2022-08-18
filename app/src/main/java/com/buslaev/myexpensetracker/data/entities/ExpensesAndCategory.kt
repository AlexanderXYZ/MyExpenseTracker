package com.buslaev.myexpensetracker.data.entities

import androidx.room.Embedded
import androidx.room.Relation

data class ExpensesAndCategory(
    @Embedded val category: CategoryEntity,
    @Relation(
        parentColumn = "category_id",
        entityColumn = "expenses_category_id"
    )
    val incomeTransaction: ExpensesTransactionEntity
)
