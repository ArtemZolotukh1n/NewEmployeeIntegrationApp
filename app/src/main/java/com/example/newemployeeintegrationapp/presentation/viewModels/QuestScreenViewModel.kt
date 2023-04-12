package com.example.newemployeeintegrationapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newemployeeintegrationapp.domain.model.Task
import com.example.newemployeeintegrationapp.domain.usecase.DeleteTaskUseCase
import com.example.newemployeeintegrationapp.domain.usecase.GetTasksByTypeUseCase
import com.example.newemployeeintegrationapp.domain.usecase.GetTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestScreenViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
    private val getTasksByTypeUseCase: GetTasksByTypeUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase
) : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val AllTasks: StateFlow<List<Task>> get() = _tasks

    private val _requiredTasks = MutableStateFlow<List<Task>>(emptyList())
    val requiredTasks: StateFlow<List<Task>> get() = _requiredTasks

    private val _optionalTasks = MutableStateFlow<List<Task>>(emptyList())
    val optionalTasks: StateFlow<List<Task>> get() = _optionalTasks

    private val _teamBuildingTasks = MutableStateFlow<List<Task>>(emptyList())
    val teamBuildingTasks: StateFlow<List<Task>> get() = _teamBuildingTasks

    private val _tasksAmount = MutableStateFlow(0)
    val tasksAmount: StateFlow<Int> get() = _tasksAmount
    private val _requiredAmount = MutableStateFlow(0)
    val requiredAmount: StateFlow<Int> get() = _requiredAmount
    private val _optionalAmount = MutableStateFlow(0)
    val optionalAmount: StateFlow<Int> get() = _optionalAmount
    private val _teamBuildingAmount = MutableStateFlow(0)
    val teamBuildingAmount: StateFlow<Int> get() = _teamBuildingAmount


    init {
        viewModelScope.launch {
            _tasks.value = getTasksUseCase.execute()
            _tasksAmount.value = _tasks.value.size
            _requiredTasks.value = getTasksByTypeUseCase.execute("REQUIRED")
            _requiredAmount.value = _requiredTasks.value.size
            _optionalTasks.value = getTasksByTypeUseCase.execute("OPTIONAL")
            _optionalAmount.value = _optionalTasks.value.size
            _teamBuildingTasks.value = getTasksByTypeUseCase.execute("TEAM_BUILDING")
            _teamBuildingAmount.value = _teamBuildingTasks.value.size
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            deleteTaskUseCase.execute(task)
            // Refresh the tasks list after deletion
            _tasks.value = getTasksUseCase.execute()
        }
    }

}
