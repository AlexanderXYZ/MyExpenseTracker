package com.buslaev.myexpensetracker.domain.repository

import com.buslaev.myexpensetracker.data.dao.CategoryDao
import com.buslaev.myexpensetracker.data.entities.CategoryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface CategoryRepository {
    suspend fun getCategories(): Flow<List<CategoryEntity>>
}

class CategoryRepositoryImpl @Inject constructor(
    private val dao: CategoryDao
) : CategoryRepository {

    override suspend fun getCategories(): Flow<List<CategoryEntity>> = flow {
        dao.getAllCategories()
    }
}