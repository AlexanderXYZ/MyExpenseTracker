package com.buslaev.myexpensetracker.di

import android.content.Context
import androidx.room.Room
import com.buslaev.myexpensetracker.data.dao.CategoryDao
import com.buslaev.myexpensetracker.data.dao.ExpensesDao
import com.buslaev.myexpensetracker.data.dao.IncomeDao
import com.buslaev.myexpensetracker.data.database.AppDatabase
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
    fun provideExpensesDao(database: AppDatabase): ExpensesDao = database.expensesDao()

    @Singleton
    @Provides
    fun provideIncomeDao(database: AppDatabase): IncomeDao = database.incomeDao()
}