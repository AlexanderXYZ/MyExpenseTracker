package com.buslaev.myexpensetracker.di

import android.content.Context
import androidx.room.Room
import com.buslaev.myexpensetracker.data.dao.CategoryDao
import com.buslaev.myexpensetracker.data.dao.TransactionDao
import com.buslaev.myexpensetracker.data.database.AppDatabase
import com.buslaev.myexpensetracker.domain.repository.CategoryRepository
import com.buslaev.myexpensetracker.domain.repository.CategoryRepositoryImpl
import com.buslaev.myexpensetracker.domain.repository.TransactionRepository
import com.buslaev.myexpensetracker.domain.repository.TransactionRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext applicationContext: Context
    ): AppDatabase = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "tracker_database"
    ).build()

    @Singleton
    @Provides
    fun provideCategoryDao(database: AppDatabase): CategoryDao = database.categoryDao()

    @Singleton
    @Provides
    fun provideTransactionDao(database: AppDatabase): TransactionDao = database.transactionDao()

    @Singleton
    @Provides
    fun provideCategoryRepository(dao: CategoryDao): CategoryRepository =
        CategoryRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideTransactionRepository(dao: TransactionDao): TransactionRepository =
        TransactionRepositoryImpl(dao)
}