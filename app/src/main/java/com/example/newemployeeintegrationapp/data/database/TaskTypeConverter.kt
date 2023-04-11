package com.example.newemployeeintegrationapp.data.database

import androidx.room.TypeConverter

//mb will use or not still thinking


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