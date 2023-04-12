package com.example.newemployeeintegrationapp.data.database

import androidx.room.TypeConverter

class TaskTypeConverter {
    @TypeConverter
    fun fromTaskType(taskType: TaskType): String {
        return taskType.name
    }

    @TypeConverter
    fun toTaskType(taskTypeString: String): TaskType {
        return TaskType.valueOf(taskTypeString)
    }
}