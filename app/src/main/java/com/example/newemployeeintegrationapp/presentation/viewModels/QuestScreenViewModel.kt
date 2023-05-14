package com.example.newemployeeintegrationapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newemployeeintegrationapp.domain.model.Task
import com.example.newemployeeintegrationapp.domain.usecase.GetTasksByTypeUseCase
import com.example.newemployeeintegrationapp.domain.usecase.GetTasksUseCase
import com.example.newemployeeintegrationapp.domain.usecase.SetTaskAsDoneUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestScreenViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
    private val getTasksByTypeUseCase: GetTasksByTypeUseCase,
    private val setTaskAsDoneUseCase: SetTaskAsDoneUseCase
) : ViewModel() {
    /*Окей - тут все говно - таски не рефрешаться в функции, так как им просто дается тот же массив тасков
    * нужна наверное переменная которая держит невыполненные таски + переменная которая держит число невыполненных или что-то такое
    * */
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val AllTasks: StateFlow<List<Task>> get() = _tasks

    private val _requiredTasks = MutableStateFlow<List<Task>>(emptyList())
    val requiredTasks: StateFlow<List<Task>> get() = _requiredTasks

    private val _optionalTasks = MutableStateFlow<List<Task>>(emptyList())
    val optionalTasks: StateFlow<List<Task>> get() = _optionalTasks

    private val _teamBuildingTasks = MutableStateFlow<List<Task>>(emptyList())
    val teamBuildingTasks: StateFlow<List<Task>> get() = _teamBuildingTasks

    private val _completedTasksAmount = MutableStateFlow(0f)
    val tasksAmount: StateFlow<Float> get() = _completedTasksAmount

    private val _completedRequiredAmount = MutableStateFlow(0f)
    val completedRequiredAmount: StateFlow<Float> get() = _completedRequiredAmount

    private val _completedOptionalAmount = MutableStateFlow(0f)
    val completedOptionalAmount: StateFlow<Float> get() = _completedOptionalAmount

    private val _completedTeamBuildingAmount = MutableStateFlow(0f)
    val completedTeamBuildingAmount: StateFlow<Float> get() = _completedTeamBuildingAmount


    init {
        viewModelScope.launch {
            refreshTasks()
        }
    }

    private suspend fun refreshTasks() {
        _tasks.value = getTasksUseCase.execute()
        _completedTasksAmount.value = _tasks.value.filter { it.isDone == 1 }.size.toFloat()

        _requiredTasks.value = getTasksByTypeUseCase.execute("REQUIRED")
        _completedRequiredAmount.value =
            _requiredTasks.value.filter { it.isDone == 1 }.size.toFloat()

        _optionalTasks.value = getTasksByTypeUseCase.execute("OPTIONAL")
        _completedOptionalAmount.value =
            _optionalTasks.value.filter { it.isDone == 1 }.size.toFloat()

        _teamBuildingTasks.value = getTasksByTypeUseCase.execute("TEAM_BUILDING")
        _completedTeamBuildingAmount.value =
            _teamBuildingTasks.value.filter { it.isDone == 1 }.size.toFloat()
    }

    fun onTaskCompleted() {
        viewModelScope.launch {
            refreshTasks()
        }
    }


    fun setTaskAsDone(taskId: Int) {
        viewModelScope.launch {
            setTaskAsDoneUseCase.invoke(taskId)
        }
    }
}
