package com.buslaev.myexpensetracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.buslaev.myexpensetracker.data.entities.CategoryEntity

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category_entity")
    suspend fun getAllCategories(): List<CategoryEntity>

    @Insert
    suspend fun insertCategory(category: CategoryEntity)

    @Delete
    suspend fun deleteCategory(category: CategoryEntity)
}