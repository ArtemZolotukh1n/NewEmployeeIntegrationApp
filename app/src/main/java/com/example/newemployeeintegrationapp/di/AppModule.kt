package com.example.newemployeeintegrationapp.di

import android.content.Context
import com.example.newemployeeintegrationapp.data.database.AppDatabase
import com.example.newemployeeintegrationapp.data.database.LeaderboardDao
import com.example.newemployeeintegrationapp.data.database.TaskDao
import com.example.newemployeeintegrationapp.data.database.UserDao
import com.example.newemployeeintegrationapp.data.repository.TaskRepository
import com.example.newemployeeintegrationapp.data.repository.UserRepository
import com.example.newemployeeintegrationapp.domain.usecase.DeleteTaskUseCase
import com.example.newemployeeintegrationapp.domain.usecase.GetTasksByTypeUseCase
import com.example.newemployeeintegrationapp.domain.usecase.GetTasksUseCase
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

    @Provides
    @Singleton
    fun provideTaskRepository(taskDao: TaskDao): TaskRepository {
        return TaskRepository(taskDao)
    }

    @Provides
    @Singleton
    fun provideGetTasksUseCase(repository: TaskRepository): GetTasksUseCase {
        return GetTasksUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetTasksByTypeUseCase(repository: TaskRepository): GetTasksByTypeUseCase {
        return GetTasksByTypeUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideDeleteTaskUseCase(repository: TaskRepository): DeleteTaskUseCase {
        return DeleteTaskUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideLeaderboardDao(appDatabase: AppDatabase): LeaderboardDao {
        return appDatabase.leaderboardDao()
    }

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepository(userDao)
    }
}