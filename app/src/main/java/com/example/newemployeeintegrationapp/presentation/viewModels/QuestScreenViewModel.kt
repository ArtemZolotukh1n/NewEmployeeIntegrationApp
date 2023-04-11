package com.example.newemployeeintegrationapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newemployeeintegrationapp.data.repository.TaskRepository
import com.example.newemployeeintegrationapp.domain.model.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class QuestScreenViewModel @Inject constructor(private val taskRepository: TaskRepository) :
    ViewModel() {
    val tasks: StateFlow<List<Task>> =
        taskRepository.getTasks().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

}
