package com.example.newemployeeintegrationapp.data.database

import androidx.room.Embedded
import androidx.room.Relation
import com.example.newemployeeintegrationapp.domain.model.Task

data class TaskWithLeaderboardEntries(
    @Embedded val task: TaskEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "taskId"
    )
    val leaderboardEntries: List<LeaderboardEntity>
)
