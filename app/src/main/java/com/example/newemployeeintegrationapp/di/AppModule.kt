package com.example.newemployeeintegrationapp.di

import android.content.Context
import androidx.room.Room
import com.example.newemployeeintegrationapp.data.database.AppDatabase
import com.example.newemployeeintegrationapp.data.database.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getInstance(context)

    @Provides
    @Singleton
    fun provideTaskDao(appDatabase: AppDatabase): TaskDao = appDatabase.taskDao()
}