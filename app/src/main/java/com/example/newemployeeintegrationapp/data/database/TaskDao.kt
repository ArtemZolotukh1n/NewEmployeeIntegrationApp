package com.example.newemployeeintegrationapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks WHERE taskType = :taskType")
    suspend fun getTasksByType(taskType: TaskType): List<TaskEntity>

    @Query("SELECT * FROM tasks")
    suspend fun getAllTasks(): List<TaskEntity>

    @Insert
    suspend fun insertTask(task: TaskEntity)

}