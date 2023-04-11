package com.example.newemployeeintegrationapp.presentation.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newemployeeintegrationapp.data.database.TaskDao
import com.example.newemployeeintegrationapp.data.database.TaskEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestScreenViewModel @Inject constructor(private val taskDao: TaskDao) : ViewModel() {
    private val _tasks = MutableStateFlow<List<TaskEntity>>(emptyList())
    val tasks: StateFlow<List<TaskEntity>> = _tasks

    init {
        viewModelScope.launch {
            _tasks.value = getTasks()
        }
    }

    suspend fun getTasks(): List<TaskEntity> {
        return taskDao.getAllTasks()
    }
}