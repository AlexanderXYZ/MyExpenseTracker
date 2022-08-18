package com.buslaev.myexpensetracker.data.entities

import androidx.room.Embedded
import androidx.room.Relation

data class TransactionAndCategory(
    @Embedded val transaction: TransactionEntity,
    @Relation(
        parentColumn = "category_id",
        entityColumn = "category_id"
    )
    val category: CategoryEntity
)
