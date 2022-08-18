package com.buslaev.myexpensetracker.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_entity")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "category_id")
    val id: Long = 0L,

    @ColumnInfo(name = "category_title")
    val title: String = "",

    @ColumnInfo(name = "category_icon")
    val icon: String = "",

    @ColumnInfo(name = "category_background_color")
    val backgroundColor: String = ""
)
