package com.example.newemployeeintegrationapp.presentation.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newemployeeintegrationapp.data.database.TaskDao
import com.example.newemployeeintegrationapp.data.database.TaskEntity
import com.example.newemployeeintegrationapp.domain.usecase.GetTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestScreenViewModel @Inject constructor(private val getTasksUseCase: GetTasksUseCase) :
    ViewModel() {
    val tasks: StateFlow<List<TaskEntity>> =
        getTasksUseCase.execute().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
}
