package com.buslaev.myexpensetracker.data.entities

import androidx.room.Embedded
import androidx.room.Relation

data class IncomeAndCategory(
    @Embedded val category: CategoryEntity,
    @Relation(
        parentColumn = "category_id",
        entityColumn = "income_category_id"
    )
    val incomeTransaction: IncomeTransactionEntity
)
