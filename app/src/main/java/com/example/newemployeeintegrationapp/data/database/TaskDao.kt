package com.example.newemployeeintegrationapp.data.database

import androidx.room.*

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks WHERE taskType = :taskType")
    suspend fun getTasksByType(taskType: String): List<TaskEntity>

    @Query("SELECT * FROM tasks")
    suspend fun getAllTasks(): List<TaskEntity>

    @Insert
    suspend fun insertTask(task: TaskEntity)

    @Delete
    suspend fun deleteTask(task: TaskEntity)

    @Transaction
    @Query("SELECT * FROM tasks")
    suspend fun getTasksWithLeaderboardEntries(): List<TaskWithLeaderboardEntries>

}