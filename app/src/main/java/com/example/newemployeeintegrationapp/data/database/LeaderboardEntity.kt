package com.example.newemployeeintegrationapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Leaderboard")
class LeaderboardEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val userId: Long,
    val taskId: Long,
    val completionDateTime: Long
)